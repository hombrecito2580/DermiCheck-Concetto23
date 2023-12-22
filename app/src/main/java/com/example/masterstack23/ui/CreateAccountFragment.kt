package com.example.masterstack23.ui

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.masterstack23.R
import com.example.masterstack23.data.CreateAccountRequest
import com.example.masterstack23.databinding.FragmentCreateAccountBinding
import com.example.masterstack23.repo.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreateAccountFragment : Fragment() {
    private val args: CreateAccountFragmentArgs by navArgs()
    private var email = ""

    private var _binding: FragmentCreateAccountBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAccountBinding.inflate(inflater, container, false)

        dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        email = args.email

        binding.tvCreatePassword.text = "Enter password for\n$email"

        binding.btnContinue.setOnClickListener {
            val password = binding.etPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()
            val name = binding.etName.text.toString().trim()

            if(validateInputs(password, confirmPassword, name)) {
                createAccountAndRedirect(email, password, name)
            }
        }

        binding.floatingActionButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun createAccountAndRedirect(email: String, password: String, name: String) {
        dialog.show()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.105:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(APIService::class.java)
        val request = CreateAccountRequest(email, password, name)

        lifecycleScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = apiService.createAccount(request)

                    if(response.isSuccessful) {
                        val statusMessage = response.body()?.message

                        withContext(Dispatchers.Main) {
                            when(statusMessage) {
                                "User registered successfully" -> {
                                    dialog.dismiss()
                                    Toast.makeText(context, "User registered successfully", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(context, HomeActivity::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                    startActivity(intent)
                                }
                                "Email already exists" -> {
                                    dialog.dismiss()
                                    Toast.makeText(context, "Account already exists", Toast.LENGTH_SHORT).show()
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

    private fun validateInputs(password: String, confirmPassword: String, name: String): Boolean {
        binding.etLtPassword.helperText = null
        binding.etLtConfirmPassword.helperText = null
        binding.etLtName.helperText = null

        if(name.isEmpty()) {
            binding.etLtName.helperText = "Please enter your name"
            return false
        }
        if(password.isEmpty()) {
            binding.etLtPassword.helperText = "Please enter a password"
            return false
        }
        if(confirmPassword.isEmpty()) {
            binding.etLtConfirmPassword.helperText = "Please confirm the password"
            return false
        }
        return true
    }

    private fun validatePassword(password: String, confirmPassword: String): Boolean {
        if(password.length < 6) {
            binding.etLtPassword.helperText = "Password must contain at least 6 characters"
            binding.etLtConfirmPassword.helperText = null
            return false
        }
        if(password != confirmPassword) {
            binding.etLtPassword.helperText = ""
            binding.etLtConfirmPassword.helperText = "Passwords do not match"
            return false
        }
        binding.etLtPassword.helperText = ""
        binding.etLtConfirmPassword.helperText = ""
        return true
    }
//
//    private fun init() {
//        floatingActionButton = binding.floatingActionButton
//        etLtPassword = binding.passwordEditTextLayout
//        etPassword = binding.passwordEditText
//        etLtConfirmPassword = binding.confirmPasswordEditTextLayout
//        etConfirmPassword = binding.confirmPasswordEditText
//        etLtPhone = binding.phoneEditTextLayout
//        etPhone = binding.phoneEditText
//        btnContinue = binding.loginContinueButton
//        headerText = binding.createPassword
//
//        dialog = Dialog(requireActivity())
//        dialog.setContentView(R.layout.progress_bar)
//        dialog.setCancelable(false)
//        if (dialog.window != null) {
//            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
//        }
//
//        email = ""
//    }

}