package com.example.mvvm1.data

import com.example.mvvm1.data.model.QuoteModel
import com.example.mvvm1.data.model.QuoteProvider
import com.example.mvvm1.data.network.QuoteService

class QuoteRepository {

    private val api=QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response=api.getQuotes()
        //guardar en una base de datos local
        QuoteProvider.quotes=response
        return response
    }


}