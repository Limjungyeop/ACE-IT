package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ComicPage1 : AppCompatActivity() {
    var rightbutton1: ImageButton? = null
    var homebutton1: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_page1)
        rightbutton1 = findViewById<View>(R.id.rightbutton1) as ImageButton
        homebutton1 = findViewById<View>(R.id.homebutton1) as ImageButton
        homebutton1!!.setOnClickListener { openMainActivity() }
        rightbutton1!!.setOnClickListener { openComicPage2() }
    }

    fun openMainActivity() {
        val mainactivity = Intent(this, MainActivity::class.java)
        startActivity(mainactivity)
    }

    fun openComicPage2() {
        val comicpage2 = Intent(this, ComicPage2::class.java)
        startActivity(comicpage2)
    }
}