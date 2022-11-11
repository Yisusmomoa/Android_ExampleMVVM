package com.example.mvvm1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm1.data.model.QuoteModel
import com.example.mvvm1.data.model.QuoteProvider
import com.example.mvvm1.domain.GetQuotesUseCase
import com.example.mvvm1.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    var getQuotesUseCase=GetQuotesUseCase()
    var getRandomQuoteUseCase=GetRandomQuoteUseCase()
    val isLoading=MutableLiveData<Boolean>()


    fun onCreate() {
        //hacemos la llamada a nuestro caso de uso
        //para que nos devuelva esa informaión
        //como es una función de tipo suspend lo que vamos a llamar,
        //tenemos que hacer uso de viewModelScope
        viewModelScope.launch {
            isLoading.postValue(true)
            val result=getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                //cuando iniciamos la app, se cargue algo de info
                isLoading.postValue(false)
            }

        }
    }

    fun randomQuote() {
        isLoading.postValue(true)

        val quote=getRandomQuoteUseCase
        if (quote!=null){
            quoteModel.postValue(quote)

        }
        isLoading.postValue(false)

       /* val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)*/
    }


}

private fun <T> MutableLiveData<T>.postValue(quote: GetRandomQuoteUseCase) {

}
