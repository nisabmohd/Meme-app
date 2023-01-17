package com.example.memes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMeme()
    }

    private fun getMeme() {
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme"
        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val img = response.getString("url")
                Glide.with(this).load(img).into(memeImg)
            },
            {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            })
        queue.add(stringRequest)
    }
    fun shareMeme(view: View) {}
    fun nextMeme(view: View) {
        getMeme()
    }
}