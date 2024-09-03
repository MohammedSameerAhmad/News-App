package com.sameerapps.newsapp.di

import android.content.Context
import com.sameerapps.newsapp.NewsApp
import com.sameerapps.newsapp.data.web.NewsApi
import com.sameerapps.newsapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
Created by Mohammed Sameer Ahmad Android learning
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext context: Context) : NewsApp{
        return context as NewsApp
    }

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context{
        return context;
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient{
        return OkHttpClient.Builder()
            .readTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsApi(retrofit: Retrofit): NewsApi{
        return retrofit.create(NewsApi::class.java )
    }

}