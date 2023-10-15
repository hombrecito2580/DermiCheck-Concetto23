package com.example.masterstack23.ui

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.masterstack23.R
import com.example.masterstack23.data.LoginRequest
import com.example.masterstack23.data.RegisterRequest
import com.example.masterstack23.databinding.FragmentCreateAccountBinding
import com.example.masterstack23.repo.APIService
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class CreateAccountFragment : Fragment() {

    private var _binding: FragmentCreateAccountBinding? = null
    private val binding get() = _binding!!


    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var headerText: TextView
    private lateinit var etLtPassword: TextInputLayout
    private lateinit var etPassword: TextInputEditText
    private lateinit var etLtConfirmPassword: TextInputLayout
    private lateinit var etConfirmPassword: TextInputEditText
    private lateinit var etLtPhone: TextInputLayout
    private lateinit var etPhone: TextInputEditText
    private lateinit var btnContinue: Button
    private lateinit var dialog: Dialog

    private lateinit var email: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        val data = arguments
        if (data != null) {
            email = data.getString("email").toString()
        }
        headerText.text = "Enter password for\n$email"

        btnContinue.setOnClickListener {
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            val phone = etPhone.text.toString()

            if(password.isEmpty()) etLtPassword.helperText = "Please enter the password"
            else if(confirmPassword.isEmpty()) etLtConfirmPassword.helperText = "Please confirm the password"

            if(password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                etLtPassword.helperText = ""
                etLtConfirmPassword.helperText = ""
                etLtPhone.helperText = ""

                val validated = validatePassword(password, confirmPassword)

                if(validated) {
                    if(etPhone.text.toString() != "") {
                        dialog.show()
                        lifecycleScope.launch {
                            val created = async { createAccountAndRedirect(email, password, phone) }
                            if(created.await() == null) {
                                Toast.makeText(context, "Error!!!!!", Toast.LENGTH_SHORT).show()
                            }
                            else if(created.await() == true) {
                                activity?.runOnUiThread {
                                    activity?.finish()
                                    startActivity(Intent(context, HomeActivity::class.java))
                                }
                            }
                            else {
                                activity?.runOnUiThread {
                                    Toast.makeText(context, "Couldn't create the account...", Toast.LENGTH_SHORT).show()
                                }
                            }
                            dialog.dismiss()
                        }
                    } else {
                        etLtPhone.helperText = "Please Enter Phone Number"
                    }
                }
                else{
                    etLtConfirmPassword.helperText="Passwords don't match."
                }


            }
        }

        floatingActionButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private suspend fun createAccountAndRedirect(email: String, password: String, phone: String): Boolean? = withContext(Dispatchers.IO) {
//        delay(3000)

        val retrofit = Retrofit.Builder().baseUrl("https://hombrecito2580.pythonanywhere.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)

        try {
            val response = retrofit.register(RegisterRequest(email, password, phone))
            if(response.isSuccessful) {
                val responseBody = response.body()
                return@withContext responseBody?.status
            } else {
                return@withContext null
            }
        } catch (e: IOException) {
            Toast.makeText(context, "Error!!!", Toast.LENGTH_SHORT).show()
            return@withContext null
        }
//
//        lifecycleScope.launch {
//            val response = async{ retrofit.checkEmail(email) }
//        return true
    }

    private fun validatePassword(password: String, confirmPassword: String): Boolean {
        if(password.length < 6) {
            etLtPassword.helperText = "Password must contain at least 6 characters"
            etLtConfirmPassword.helperText = ""
            return false
        }
        if(password != confirmPassword) {
            etLtPassword.helperText = ""
            etLtConfirmPassword.helperText = "Passwords do not match"
            return false
        }
        return true
    }

    private fun init() {
        floatingActionButton = binding.floatingActionButton
        etLtPassword = binding.passwordEditTextLayout
        etPassword = binding.passwordEditText
        etLtConfirmPassword = binding.confirmPasswordEditTextLayout
        etConfirmPassword = binding.confirmPasswordEditText
        etLtPhone = binding.phoneEditTextLayout
        etPhone = binding.phoneEditText
        btnContinue = binding.loginContinueButton
        headerText = binding.createPassword

        dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        email = ""
    }

}