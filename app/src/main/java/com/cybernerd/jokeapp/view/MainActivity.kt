package com.cybernerd.jokeapp.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cybernerd.jokeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonGetJoke.setOnClickListener {
            val intent = Intent(this, JokeScreen::class.java)
            startActivity(intent)
        }

        binding.buttonGithubLink.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://github.com/yeshuwahane/RandomJokeApp-Andriod"))
            startActivity(intent)
        }




    }
}