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
import com.example.masterstack23.R
import com.example.masterstack23.databinding.FragmentForgotPasswordBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.regex.Pattern

class ForgotPasswordFragment : Fragment() {

    private var _binding: FragmentForgotPasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var emailEditTextLayout: TextInputLayout
    private lateinit var emailEditText: TextInputEditText
    private lateinit var loginContinueButton: Button
    private lateinit var dialog: Dialog

    private lateinit var email: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        loginContinueButton.setOnClickListener {
//            email = emailEditText.text.toString().trim()
//            if (isValid(email)) {
//                var sentOTP = false
//
//                dialog.show()
//
//                runBlocking {
//                    sentOTP = sendOTP(email)
//                }
//
//                if (sentOTP) {
//                    Toast.makeText(context, "OTP Sent to email", Toast.LENGTH_SHORT).show()
//                    dialog.dismiss()
//                    val intent = activity?.intent;
//                    activity?.finish();
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(context, "error!!!", Toast.LENGTH_SHORT).show()
//                }
//                dialog.dismiss()
//
//            }
        }

        floatingActionButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private suspend fun sendOTP(email: String): Boolean {
        delay(3000)
        return true
    }

    private fun isValid(email: String): Boolean {
        if (email.isEmpty()) {
            emailEditTextLayout.helperText = "Please enter the Email"
            return false
        }

        val pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}\$")
        val matcher = pattern.matcher(email)

        return if (matcher.matches()) {
            true
        } else {
            emailEditTextLayout.helperText = "Invalid Email"
            false
        }
    }

    private fun init() {
        floatingActionButton = binding.floatingActionButton
        emailEditTextLayout = binding.emailEditTextLayout
        emailEditText = binding.emailEditText
        loginContinueButton = binding.loginContinueButton

        dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        email = ""
    }

}