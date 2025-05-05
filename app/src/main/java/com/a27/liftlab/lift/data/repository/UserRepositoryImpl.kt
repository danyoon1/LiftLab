package com.a27.liftlab.lift.data.repository

import com.a27.liftlab.lift.data.api.UserApi
import com.a27.liftlab.lift.data.dto.LoginRequest
import com.a27.liftlab.lift.data.dto.RegisterRequest
import com.a27.liftlab.lift.domain.repository.UserRepository

class UserRepositoryImpl(private val api: UserApi) : UserRepository {

    override suspend fun register(user: String, password: String): Result<String> {
        return try {
            val response = api.register(RegisterRequest(user, password))
            if (response.isSuccessful) {
                Result.success(response.body()?.success ?: "Registered")
            } else {
                Result.failure(Exception("Register failed: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun login(user: String, password: String): Result<String> {
        return try {
            val response = api.login(LoginRequest(user, password))
            if (response.isSuccessful) {
                Result.success(response.body()?.success ?: "Login success")
            } else {
                Result.failure(Exception("Login failed: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}