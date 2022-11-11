package com.example.mvvm1.data.network

import com.example.mvvm1.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    //el resto de la url, puede ser /users/:idUser, etc
    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}