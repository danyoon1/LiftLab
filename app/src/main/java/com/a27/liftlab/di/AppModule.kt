package com.a27.liftlab.di

import com.a27.liftlab.lift.data.api.WorkoutApi
import com.a27.liftlab.lift.data.repository.WorkoutRepositoryImpl
import com.a27.liftlab.lift.domain.repository.WorkoutRepository
import com.a27.liftlab.lift.presentation.view_models.WorkoutViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WorkoutApi::class.java)
    }

    single<WorkoutRepository> { WorkoutRepositoryImpl(get()) }

    viewModelOf(::WorkoutViewModel)
}