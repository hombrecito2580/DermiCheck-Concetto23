package com.example.masterstack23.repo

import com.example.masterstack23.data.CheckAccountRequest
import com.example.masterstack23.data.CheckAccountResponse
import com.example.masterstack23.data.CreateAccountRequest
import com.example.masterstack23.data.CreateAccountResponse
import com.example.masterstack23.data.LoginRequest
import com.example.masterstack23.data.LoginResponse
import com.example.masterstack23.data.StatusResponse
import com.example.masterstack23.data.UploadTestResponse
import com.example.masterstack23.data.VerifyTokenRequest
import com.example.masterstack23.data.VerifyTokenResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface APIService {

    @POST("/check-account")
    suspend fun checkAccount(@Body request: CheckAccountRequest): Response<CheckAccountResponse>

    @POST("/create-account")
    suspend fun createAccount(@Body body: CreateAccountRequest): Response<CreateAccountResponse>

    @POST("/login")
    suspend fun login(@Body body: LoginRequest): Response<LoginResponse>

    @POST("/verify-token")
    suspend fun verifyToken(@Body body: VerifyTokenRequest): Response<VerifyTokenResponse>

    @Multipart
    @POST("/uploadTest")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part
    ): Response<UploadTestResponse>

    @POST("/checkEmail")
    suspend fun checkEmail(
        @Body email: String
    ): Response<StatusResponse>


}