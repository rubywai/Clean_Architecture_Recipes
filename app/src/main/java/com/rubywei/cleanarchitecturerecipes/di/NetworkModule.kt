package com.rubywei.cleanarchitecturerecipes.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rubywei.cleanarchitecturerecipes.data.api.FoodApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun getOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun kotlinXConverter() : Converter.Factory{
        val contentType = "application/json".toMediaType()
        return Json.asConverterFactory(contentType)
    }

    @Provides
    @Singleton
    fun getHttpLogging() : HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient,converter: Converter.Factory) : Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(converter)
        .build()

    @Provides
    @Singleton
    fun foodApi(retrofit: Retrofit) : FoodApi = retrofit.create(FoodApi::class.java)

    @RequiresApi(Build.VERSION_CODES.M)
    @Provides
    @Singleton
    fun hasInternetConnection(
        @ApplicationContext  context: Context
    ): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}