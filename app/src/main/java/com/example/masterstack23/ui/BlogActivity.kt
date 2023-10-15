package com.example.masterstack23.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.masterstack23.databinding.ActivityBlogBinding

class BlogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBlogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.blogtitle.text=intent.getStringExtra("Title")
        binding.blogt1.text=intent.getStringExtra("text1")
        binding.blogt2.text=intent.getStringExtra("text2")

        val id = intent.getIntExtra("image", 0)
        binding.blogimg.setImageResource(id)
    }
}
