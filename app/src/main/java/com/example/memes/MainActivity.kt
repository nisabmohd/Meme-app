package com.example.memes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //https://meme-api.com/gimme

    fun shareMeme(view: View) {}
    fun nextMeme(view: View) {}
}