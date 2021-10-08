package com.cybernerd.jokeapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cybernerd.jokeapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_get_joke.setOnClickListener {
            val intent = Intent(this, JokeScreen::class.java)
            startActivity(intent)
        }

        button_github_link.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse("https://github.com/yeshuwahane/RandomJokeApp-Andriod"))
            startActivity(intent)
        }




    }
}