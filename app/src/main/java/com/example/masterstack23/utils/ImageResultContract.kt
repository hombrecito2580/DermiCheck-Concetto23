package com.example.masterstack23.utils

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract

class PickImageContract: ActivityResultContract<Unit, Uri>() {
    override fun createIntent(context: Context, input: Unit): Intent {
        return Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri {
        return intent?.data!!
    }

}

class CaptureImageContract : ActivityResultContract<Unit, Uri>() {
    override fun createIntent(context: Context, input: Unit): Intent {
        val values = ContentValues()
        val imageUri = context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        return intent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri {
        return intent?.data!!
    }

}