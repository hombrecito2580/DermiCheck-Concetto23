package com.example.masterstack23.utils

import android.view.LayoutInflater
import android.view.View
import com.example.masterstack23.databinding.LayoutSnackbarBinding
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(message: String, view: View) {

    val snackbar = Snackbar.make(view, "", Snackbar.LENGTH_SHORT)
    val snackbarLayout = snackbar.view as? Snackbar.SnackbarLayout
    snackbarLayout?.setPadding(0, 0, 0, 0)
    val binding = LayoutSnackbarBinding.inflate(LayoutInflater.from(view.context))
    binding.tvMessage.text = message
    snackbarLayout?.addView(binding.root)

    return snackbar.show()

}