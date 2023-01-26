package com.example.memes

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
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
    var image=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMeme()
    }

    private fun getMeme() {
        loader.visibility = View.VISIBLE
        memeImg.visibility = View.INVISIBLE
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme"
        val stringRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val img = response.getString("url")
                image=img;
                Glide.with(this).load(img).into(memeImg)
                loader.visibility = View.INVISIBLE
                memeImg.visibility = View.VISIBLE
            },
            {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                loader.visibility = View.INVISIBLE
            }
        )
        queue.add(stringRequest)
    }

    fun shareMeme(view: View) {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type="text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, image);
        startActivity(Intent.createChooser(shareIntent,"Share Via"))
    }
    fun nextMeme(view: View) {
        getMeme()
    }
}