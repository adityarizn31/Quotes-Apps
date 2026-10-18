package com.example.pagingapps.di

import android.content.Context
import com.example.pagingapps.data.QuoteRepository
import com.example.pagingapps.network.ApiConfig

object Injection {
    fun provideRepository(context: Context): QuoteRepository {
        val apiService = ApiConfig.getApiService()
        return QuoteRepository(apiService)
    }
}
