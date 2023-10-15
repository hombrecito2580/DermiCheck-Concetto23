package com.example.masterstack23.ui

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.masterstack23.R
import com.example.masterstack23.databinding.FragmentLoginWithEmailBinding
import com.example.masterstack23.repo.APIService
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.regex.Pattern

class LoginWithEmailFragment : Fragment() {

    private var _binding: FragmentLoginWithEmailBinding? = null
    private val binding get() = _binding!!

    private lateinit var loginEmailEditTextLayout: TextInputLayout
    private lateinit var loginEmailEditText: TextInputEditText
    private lateinit var loginContinueButton: Button
    private lateinit var email: String
    private lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginWithEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        loginContinueButton.setOnClickListener {
            email = loginEmailEditText.text.toString().trim()
            if (isValid(email)) {
                redirect(email)
            }
        }

    }

    private fun isValid(email: String): Boolean {
        if (email.isEmpty()) {
            loginEmailEditTextLayout.helperText = "Please enter the Email"
            return false
        }

        val pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
        val matcher = pattern.matcher(email)

        return if (matcher.matches()) {
            true
        } else {
            loginEmailEditTextLayout.helperText = "Invalid Email"
            false
        }
    }

    private fun redirect(email: String) {
        dialog.show()

        lifecycleScope.launch {
            val bundle = Bundle()
            bundle.putString("email", email)

            val exists = async { exists(email) }

            if(exists.await() == null) {
                Toast.makeText(context, "Error!!!!!", Toast.LENGTH_SHORT).show()
            }
            else if(exists.await() == true) {
                activity?.runOnUiThread {
                    findNavController().navigate(R.id.action_loginWithEmailFragment_to_loginPasswordFragment, bundle)
                }
            }
            else {
                activity?.runOnUiThread {
                    findNavController().navigate(R.id.action_loginWithEmailFragment_to_createAccountFragment, bundle)
                }
            }

            dialog.dismiss()
        }
    }

    private suspend fun exists(email: String): Boolean? = withContext(Dispatchers.IO) {

        val retrofit = Retrofit.Builder().baseUrl("https://hombrecito2580.pythonanywhere.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)

        try {
            val response = retrofit.checkEmail(email)
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

//        val response = retrofit.checkEmail(email)
//        if(response.isSuccessful) {
//            return@withContext response.body() == true
//        }
//        else {
//            return@withContext null
//        }

//        runBlocking {
//            lifecycleScope.launch {
//                val response = async{ retrofit.checkEmail(email) }
//                val status = response.await()
//                if (status != null) {
//                    exists = status
//                    if(exists) Toast.makeText(context, "LoginPassword", Toast.LENGTH_SHORT).show()
//                    else Toast.makeText(context, "CreateAccount", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(context, "Error Response", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//        return@withContext exists
    }

    private fun init() {
        loginEmailEditTextLayout = binding.loginEMailEditTextLayout
        loginEmailEditText = binding.loginEMailEditText
        loginContinueButton = binding.loginContinueButton

        email = ""

        dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }
    }

}