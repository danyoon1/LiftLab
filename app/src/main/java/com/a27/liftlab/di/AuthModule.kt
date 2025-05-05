package com.a27.liftlab.di

import com.a27.liftlab.lift.data.api.UserApi
import com.a27.liftlab.lift.data.repository.UserRepositoryImpl
import com.a27.liftlab.lift.domain.repository.UserRepository
import com.a27.liftlab.lift.presentation.view_models.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val authModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    single<UserRepository> { UserRepositoryImpl(get()) }

    viewModelOf(::AuthViewModel)
}