package com.example.masterstack23.data

data class UploadTestResponse(
    val status: Boolean,
    val disease: String,
    val cure: String,
    val symptoms: List<String>,
    val url: String
)
