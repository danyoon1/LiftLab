package com.a27.liftlab.lift.domain.repository

interface UserRepository {
    suspend fun register(user: String, password: String): Result<String>
    suspend fun login(user: String, password: String): Result<String>
}