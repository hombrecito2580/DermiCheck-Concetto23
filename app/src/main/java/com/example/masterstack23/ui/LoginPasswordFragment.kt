package com.example.masterstack23.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.masterstack23.R
import com.example.masterstack23.data.LoginRequest
import com.example.masterstack23.databinding.FragmentLoginPasswordBinding
import com.example.masterstack23.repo.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginPasswordFragment : Fragment() {
    private val args: LoginPasswordFragmentArgs by navArgs()
    private var email = ""

    private var _binding: FragmentLoginPasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginPasswordBinding.inflate(inflater, container, false)

        dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        val layoutParams = WindowManager.LayoutParams().apply {
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.MATCH_PARENT
        }
        dialog.window?.attributes = layoutParams
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(requireContext(), R.color.white)))
        }
        // ColorDrawable(0)

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = args.email

        binding.tvEnterPassword.text = "Enter password for\n$email"

        binding.btnContinue.setOnClickListener {
            val password = binding.etPassword.text.toString()

            if(validatePassword(password)) {
                loginAndRedirect(email, password)
            }
        }

        binding.btnForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginPasswordFragment_to_forgotPasswordFragment)
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun loginAndRedirect(email: String, password: String) {
        dialog.show()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.105:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(APIService::class.java)
        val request = LoginRequest(email, password)

        lifecycleScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = apiService.login(request)

                    if(response.isSuccessful) {
                        val statusMessage = response.body()?.message

                        withContext(Dispatchers.Main) {
                            when(statusMessage) {
                                "Login successful" -> {
                                    val sharedPreferences = requireContext().getSharedPreferences("My_Preferences", Context.MODE_PRIVATE)
                                    val editor = sharedPreferences.edit()
                                    editor.putString("user_token", response.body()?.token!!)
                                    editor.apply()

                                    dialog.dismiss()
                                    Toast.makeText(context, "User registered successfully", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(context, HomeActivity::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                    startActivity(intent)
                                }
                                "Invalid credentials" -> {
                                    dialog.dismiss()
                                    Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
                                }
                                "Email doesn't exist" -> {
                                    dialog.dismiss()
                                    Toast.makeText(context, "Account doesn't exist", Toast.LENGTH_SHORT).show()
                                }
                                else -> {
                                    dialog.dismiss()
                                    Toast.makeText(context, statusMessage, Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            dialog.dismiss()
                            Toast.makeText(context, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } catch (e: Exception) {
                dialog.dismiss()
                Toast.makeText(context, "Unexpected Error occurred", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }

    private fun validatePassword(password: String): Boolean {
        binding.etLtPassword.helperText = null

        if(password.isEmpty()) {
            binding.etLtPassword.helperText = "Please enter the password"
            return false
        }
        return true
    }
}