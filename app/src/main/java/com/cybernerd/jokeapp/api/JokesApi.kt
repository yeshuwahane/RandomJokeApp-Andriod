package com.cybernerd.jokeapp.api

import com.cybernerd.jokeapp.model.JokesModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val newEndPoint = "jokes/random"
private const val BASE_URL = "https://api.chucknorris.io/"


interface JokesApi {
    companion object{
        operator fun invoke(): JokesApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JokesApi::class.java)
        }
    }

    @GET(newEndPoint)
    fun getRandomJoke(): Call<JokesModel>
}
