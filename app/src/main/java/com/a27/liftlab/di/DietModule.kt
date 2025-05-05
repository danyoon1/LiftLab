package com.a27.liftlab.di

import com.a27.liftlab.lift.data.api.DietApi
import com.a27.liftlab.lift.data.repository.DietRepositoryImpl
import com.a27.liftlab.lift.domain.repository.DietRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.a27.liftlab.lift.presentation.view_models.DietViewModel

val dietModule = module {

    single {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DietApi::class.java)
    }

    single<DietRepository> { DietRepositoryImpl(get()) }

    viewModelOf(::DietViewModel)

}