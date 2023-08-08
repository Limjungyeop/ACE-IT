package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class InfoPage1 : AppCompatActivity() {
    var backtomenubutton: ImageButton? = null
    var rightbutton4: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_page1)
        rightbutton4 = findViewById<View>(R.id.rightbutton4) as ImageButton
        backtomenubutton = findViewById<View>(R.id.backtomenubutton) as ImageButton
        rightbutton4!!.setOnClickListener { openInfoPage2() }
        backtomenubutton!!.setOnClickListener { openMenu() }
    }

    fun openMenu() {
        val menu = Intent(this, Menu::class.java)
        startActivity(menu)
    }

    fun openInfoPage2() {
        val infopage2 = Intent(this, InfoPage2::class.java)
        startActivity(infopage2)
    }
}