package com.example.mvvm1.domain

import com.example.mvvm1.data.QuoteRepository
import com.example.mvvm1.data.model.QuoteModel
import com.example.mvvm1.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    private val repository=QuoteRepository()

    operator fun invoke():QuoteModel?{
        //repository.getAllQuotes()
        val quotes=QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            return quotes[3]
        }
        return null
    }

}