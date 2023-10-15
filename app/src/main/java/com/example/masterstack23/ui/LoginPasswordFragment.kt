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
import androidx.navigation.fragment.findNavController
import com.example.masterstack23.R
import com.example.masterstack23.databinding.FragmentLoginPasswordBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginPasswordFragment : Fragment() {

    private var _binding: FragmentLoginPasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var headerText: TextView
    private lateinit var passwordEditTextLayout: TextInputLayout
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var forgotPasswordButton: Button
    private lateinit var loginContinueButton: Button
    private lateinit var dialog: Dialog

    private lateinit var email: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginPasswordBinding.inflate(inflater, container, false)
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

        loginContinueButton.setOnClickListener {
            val password = passwordEditText.text.toString()
            if (password.isEmpty()) passwordEditTextLayout.helperText = "Please enter the password"
            else {
                dialog.show()
                lifecycleScope.launch {
                    val authenticated = async { authenticate(email, password) }
                    if(authenticated.await()) {
                        startActivity(Intent(requireActivity(), HomeActivity::class.java))
                        activity?.finish()
                    } else {
                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                    }
                    dialog.dismiss()
                }
            }
        }

        forgotPasswordButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginPasswordFragment_to_forgotPasswordFragment)
        }

        floatingActionButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private suspend fun authenticate(email: String, password: String): Boolean {
        delay(3000)
        return true
    }

    private fun init() {
        floatingActionButton = binding.floatingActionButton
        headerText = binding.enterPassword2
        passwordEditTextLayout = binding.passwordEditTextLayout
        passwordEditText = binding.passwordEditText
        forgotPasswordButton = binding.forgotPasswordButton
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