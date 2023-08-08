package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ComicPage2 : AppCompatActivity() {
    var leftbutton1: ImageButton? = null
    var rightbutton2: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_page2)
        rightbutton2 = findViewById<View>(R.id.rightbutton2) as ImageButton
        leftbutton1 = findViewById<View>(R.id.leftbutton1) as ImageButton
        leftbutton1!!.setOnClickListener { openComicPage1() }
        rightbutton2!!.setOnClickListener { openComicPage3() }
    }

    fun openComicPage1() {
        val comicpage1 = Intent(this, ComicPage1::class.java)
        startActivity(comicpage1)
    }

    fun openComicPage3() {
        val comicpage3 = Intent(this, ComicPage3::class.java)
        startActivity(comicpage3)
    }
}