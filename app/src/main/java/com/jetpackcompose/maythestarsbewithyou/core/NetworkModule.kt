package com.jetpackcompose.maythestarsbewithyou.core

import com.jetpackcompose.maythestarsbewithyou.data.network.HoroscopeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://aztro.sameerkumar.website")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    //Falta meter las cabeceras!!!

    @Provides
    fun provideHoroscopeApi (retrofit: Retrofit): HoroscopeApi = retrofit.create(HoroscopeApi::class.java)


}