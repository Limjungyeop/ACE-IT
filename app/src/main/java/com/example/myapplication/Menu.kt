package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Menu : AppCompatActivity() {
    var storybutton: ImageButton? = null
    var playbutton: ImageButton? = null
    var bookbutton: ImageButton? = null
    var infobutton: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        infobutton = findViewById(R.id.infoButton)
        infobutton!!.setOnClickListener { openInfo() }

        bookbutton = findViewById<View>(R.id.bookbutton) as ImageButton
        bookbutton!!.setOnClickListener { openBook() }

        storybutton = findViewById<View>(R.id.storybutton) as ImageButton
        storybutton!!.setOnClickListener { openStory() }

        playbutton = findViewById<View>(R.id.playbutton) as ImageButton
        playbutton!!.setOnClickListener { openPlay() }
    }

    fun openStory() {
        val comicpage1 = Intent(this, ComicPage1::class.java)
        startActivity(comicpage1)
    }

    fun openPlay() {
        val level = Intent(this, Level::class.java)
        startActivity(level)
    }
    fun openBook() {
        val infopage1 = Intent(this, InfoPage1::class.java)
        startActivity(infopage1)
    }
    fun openInfo() {
        val newinfopage1 = Intent(this, Newinfopage::class.java)
        startActivity(newinfopage1)
    }
}