package com.example.masterstack23.ui

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.masterstack23.R
import com.example.masterstack23.data.VerifyTokenRequest
import com.example.masterstack23.databinding.ActivityHomeBinding
import com.example.masterstack23.repo.APIService
import com.example.masterstack23.view_model.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {
    private lateinit var sharedViewModel: SharedViewModel

    private lateinit var binding: ActivityHomeBinding
    private lateinit var flFragment: FragmentContainerView
    private lateinit var navBottom: BottomNavigationView

    private lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]

        dialog = Dialog(this)
        dialog.setContentView(R.layout.progress_bar)
        dialog.setCancelable(false)
        val layoutParams = WindowManager.LayoutParams().apply {
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.MATCH_PARENT
        }
        dialog.window?.attributes = layoutParams
        if (dialog.window != null) {
            dialog.window!!.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.white)))
        }
        // ColorDrawable(0)

        fetchEmail()

        flFragment = binding.flFragment
        navBottom = binding.navBottom

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.flFragment) as NavHostFragment
        val navController = navHostFragment.navController
        navBottom.setupWithNavController(navController)
    }

    private fun fetchEmail() {
        val sharedPreferences = getSharedPreferences("My_Preferences", Context.MODE_PRIVATE)
        val storedToken = sharedPreferences?.getString("user_token", null)

        if(storedToken != null) {
            dialog.show()

            val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.0.105:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val apiService = retrofit.create(APIService::class.java)
            val request = VerifyTokenRequest(storedToken)

            lifecycleScope.launch {
                try {
                    withContext(Dispatchers.IO) {
                        val response = apiService.verifyToken(request)

                        if(response.isSuccessful) {
                            val statusMessage = response.body()?.message

                            withContext(Dispatchers.Main) {
                                when(statusMessage) {
                                    "Token is valid" -> {
                                        sharedViewModel.email = response.body()?.email
                                    }
                                    else -> {
                                        val editor = sharedPreferences.edit()
                                        editor.remove("user_token")
                                        editor.apply()

                                        Toast.makeText(this@HomeActivity, "Unexpected error occurred, please login again", Toast.LENGTH_SHORT).show()
                                        val intent = Intent(this@HomeActivity, LoginActivity::class.java)
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                        startActivity(intent)
                                    }
                                }
                                dialog.dismiss()
                            }
                        } else {
                            withContext(Dispatchers.Main) {
                                dialog.dismiss()
                                Toast.makeText(this@HomeActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                } catch (e: Exception) {
                    dialog.dismiss()
                    Toast.makeText(this@HomeActivity, "Unexpected Error occurred", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
        } else {
            dialog.dismiss()
            val intent = Intent(this, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}