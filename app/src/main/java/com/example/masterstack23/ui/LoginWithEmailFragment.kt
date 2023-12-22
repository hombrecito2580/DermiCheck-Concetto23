package com.example.masterstack23.ui

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.masterstack23.R
import com.example.masterstack23.data.CheckAccountRequest
import com.example.masterstack23.databinding.FragmentLoginWithEmailBinding
import com.example.masterstack23.repo.APIService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.regex.Pattern

class LoginWithEmailFragment : Fragment() {

    private var _binding: FragmentLoginWithEmailBinding? = null
    private val binding get() = _binding!!

    private lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginWithEmailBinding.inflate(inflater, container, false)

        dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginContinueButton.setOnClickListener {
            val email = binding.loginEMailEditText.text.toString().trim()
            if (isValid(email)) {
                redirect(email)
            }
        }

    }

    private fun isValid(email: String): Boolean {
        if (email.isEmpty()) {
            binding.loginEMailEditTextLayout.helperText = "Please enter the Email"
            return false
        }

        val pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
        val matcher = pattern.matcher(email)

        return if (matcher.matches()) {
            binding.loginEMailEditTextLayout.helperText = null
            true
        } else {
            binding.loginEMailEditTextLayout.helperText = "Invalid Email"
            false
        }
    }

    private fun redirect(email: String) {
        dialog.show()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.0.105:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(APIService::class.java)
        val request = CheckAccountRequest(email)

        lifecycleScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val response = apiService.checkAccount(request)

                    if(response.isSuccessful) {
                        val statusMessage = response.body()?.message

                        withContext(Dispatchers.Main) {
                            when(statusMessage) {
                                "Account exists" -> {
                                    val direction = LoginWithEmailFragmentDirections.actionLoginWithEmailFragmentToLoginPasswordFragment(email)
                                    findNavController().navigate(direction)
                                }
                                "Account not found" -> {
                                    val direction = LoginWithEmailFragmentDirections.actionLoginWithEmailFragmentToCreateAccountFragment(email)
                                    findNavController().navigate(direction)
                                }
                                else -> {
                                    Toast.makeText(context, "Unexpected response: ${response.code()}", Toast.LENGTH_SHORT).show()
                                }
                            }
                            dialog.dismiss()
                        }
                    } else {
                        Toast.makeText(context, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                dialog.dismiss()
                Toast.makeText(context, "Unexpected Error occurred", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }
}