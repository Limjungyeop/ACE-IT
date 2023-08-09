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
        infobutton!!.setOnClickListener {
            val openinfopage = Intent(this, Newinfopage::class.java)
            startActivity(openinfopage)
        }

        bookbutton = findViewById<View>(R.id.bookbutton) as ImageButton
        storybutton = findViewById<View>(R.id.storybutton) as ImageButton
        playbutton = findViewById<View>(R.id.playbutton) as ImageButton
        bookbutton!!.setOnClickListener { openInfoPage1() }
        storybutton!!.setOnClickListener { openComicPage1() }
        playbutton!!.setOnClickListener { openLevel() }
    }

    fun openComicPage1() {
        val comicpage1 = Intent(this, ComicPage1::class.java)
        startActivity(comicpage1)
    }

    fun openLevel() {
        val level = Intent(this, Level::class.java)
        startActivity(level)
    }
    fun openInfoPage1() {
        val infopage1 = Intent(this, InfoPage1::class.java)
        startActivity(infopage1)
    }
}