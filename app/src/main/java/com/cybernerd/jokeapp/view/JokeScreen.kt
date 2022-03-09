package com.cybernerd.jokeapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.cybernerd.jokeapp.databinding.ActivityJokeScreenBinding

class JokeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityJokeScreenBinding

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJokeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)



        viewModel.getAllJokes()

        viewModel.jokesLiveData.observe(this, Observer {

            binding.jokesTv.text = it.value
            Glide.with(this@JokeScreen)
                .load(it.icon_url)
               .into(binding.jokeImageIv)
        })

        binding.buttonRefresh.setOnClickListener {

            binding.progressbar.visibility = View.VISIBLE
            viewModel.getAllJokes()
        }

    }




}