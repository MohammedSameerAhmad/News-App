package com.sameerapps.newsapp.data.web

import retrofit2.Response
import retrofit2.http.GET

/**
Created by Mohammed Sameer Ahmad Android learning
 */
interface NewsApi {
    @GET("")
    suspend fun getNews(): Response<String>
}