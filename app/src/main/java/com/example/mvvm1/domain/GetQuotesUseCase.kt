package com.example.mvvm1.domain

import com.example.mvvm1.data.QuoteRepository
import com.example.mvvm1.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository=QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>?{
        return repository.getAllQuotes()
    }
}