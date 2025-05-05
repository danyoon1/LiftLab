package com.a27.liftlab.lift.data.api

import com.a27.liftlab.lift.data.dto.LoginRequest
import com.a27.liftlab.lift.data.dto.LoginResponse
import com.a27.liftlab.lift.data.dto.RegisterRequest
import com.a27.liftlab.lift.data.dto.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<RegisterResponse>

    @POST("auth")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>
}