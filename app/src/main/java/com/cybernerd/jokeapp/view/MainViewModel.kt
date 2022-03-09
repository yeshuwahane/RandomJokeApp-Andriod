package com.cybernerd.jokeapp.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cybernerd.jokeapp.model.JokesModel
import com.cybernerd.jokeapp.api.JokesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    var TAG = "JokeApp"

      val jokesLiveData: MutableLiveData<JokesModel> = MutableLiveData()


    fun getAllJokes(){
        JokesApi().getRandomJoke().enqueue(object : Callback<JokesModel>{
            override fun onResponse(call: Call<JokesModel>, response: Response<JokesModel>) {
                Log.d(TAG,"Successful ${response.body()}")
                jokesLiveData.value = response.body()
            }

            override fun onFailure(call: Call<JokesModel>, t: Throwable) {

                Log.d(TAG,"Failed ${t.message}")

            }

        })
    }
}