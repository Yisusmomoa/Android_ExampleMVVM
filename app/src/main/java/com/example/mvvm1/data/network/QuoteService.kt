package com.example.mvvm1.data.network

import com.example.mvvm1.core.RetrofitHelper
import com.example.mvvm1.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit=RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        //ejecuta toda la llammada en un hilo secundario
        return withContext(Dispatchers.IO){
        val response=retrofit.create(QuoteApiClient::class.java).getAllQuotes()
         response.body()?: emptyList()
        }
    }

}