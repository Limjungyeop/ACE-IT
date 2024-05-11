package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ComicPage3 : AppCompatActivity() {
    var leftbutton2: ImageButton? = null
    var rightbutton3: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_page3)
        rightbutton3 = findViewById<View>(R.id.rightbutton3) as ImageButton
        leftbutton2 = findViewById<View>(R.id.leftbutton2) as ImageButton
        leftbutton2!!.setOnClickListener {
            openComicPage2()
        }
        rightbutton3!!.setOnClickListener {
            openMenu()
        }
    }

    fun openComicPage2() {
        val comicpage2 = Intent(this, ComicPage2::class.java)
        startActivity(comicpage2)
    }
    fun openMenu() {
        val menu = Intent(this, Menu::class.java)
        startActivity(menu)
    }


}