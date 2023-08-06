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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        storybutton = findViewById<View>(R.id.storybutton) as ImageButton
        playbutton = findViewById<View>(R.id.playbutton) as ImageButton
        bookbutton = findViewById<View>(R.id.bookbutton) as ImageButton
        storybutton!!.setOnClickListener { openComicPage1() }
        playbutton!!.setOnClickListener { openQuiz() }
        bookbutton!!.setOnClickListener { openInfoPage1() }
    }

    fun openComicPage1() {
        val comicpage1 = Intent(this, ComicPage1::class.java)
        startActivity(comicpage1)
    }

    fun openQuiz() {
        val quiz = Intent(this, Quiz::class.java)
        startActivity(quiz)
    }

    fun openInfoPage1() {
        val infopage1 = Intent(this, InfoPage1::class.java)
        startActivity(infopage1)
    }
}