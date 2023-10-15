package com.example.masterstack23.repo

import com.example.masterstack23.data.LoginRequest
import com.example.masterstack23.data.RegisterRequest
import com.example.masterstack23.data.StatusResponse
import com.example.masterstack23.data.StatusTokenResponse
import com.example.masterstack23.data.UploadTestResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface APIService {

    @Multipart
    @POST("/uploadTest")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part
    ): Response<UploadTestResponse>

    @POST("/checkEmail")
    suspend fun checkEmail(
        @Body email: String
    ): Response<StatusResponse>

    @POST("/login")
    suspend fun login(
        @Body email: String,
        @Body password: String
    ): Response<StatusResponse>

    @POST("/register")
    suspend fun register(
        @Body loginRequest: RegisterRequest
    ): Response<StatusTokenResponse>

}