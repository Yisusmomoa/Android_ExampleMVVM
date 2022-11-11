package com.example.mvvm1.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
                //aquí debe de ir la url base de mi api
            .baseUrl("https://console.firebase.google.com/u/0/project/drawsomething-59328/database/drawsomething-59328-default-rtdb/data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}