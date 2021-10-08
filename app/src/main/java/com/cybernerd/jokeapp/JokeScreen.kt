package com.cybernerd.jokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.cybernerd.jokeapp.R
import kotlinx.android.synthetic.main.activity_joke_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_screen)

        progressbar.visibility = View.VISIBLE
        getJokesApi()

        button_refresh.setOnClickListener {
            progressbar.visibility = View.VISIBLE
            getJokesApi()
        }


    }

    //Calling Api to get jokes
    fun getJokesApi() {
        JokesApi().getRandomJoke().enqueue(object : Callback<JokesModel> {
            override fun onResponse(call: Call<JokesModel>, response: Response<JokesModel>) {
                Log.d("jokes", "this is success  ${response.body()!!.value}")
                jokes_tv.text = response.body()!!.value
                Glide.with(this@JokeScreen)
                    .load(response.body()!!.icon_url)
                    .into(joke_image_iv)
                progressbar.visibility = View.GONE
            }

            override fun onFailure(call: Call<JokesModel>, t: Throwable) {
                Log.d("jokes", "this is failed  ${t.message}")
                progressbar.visibility = View.GONE
                jokes_tv.text = "Something went wrong"
            }

        })

    }
}