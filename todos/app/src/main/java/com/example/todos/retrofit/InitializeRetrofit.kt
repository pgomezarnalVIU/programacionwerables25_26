package com.example.todos.retrofit

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object InitializeRetrofit {
    val todoApi: TodoApi by lazy {
        Retrofit.Builder()
            //.baseUrl("https://jsonplaceholder.typicode.com")
            //.baseUrl("http://localhost:3000/")
            .baseUrl("http://192.168.0.102:3000/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(TodoApi::class.java)
    }
}