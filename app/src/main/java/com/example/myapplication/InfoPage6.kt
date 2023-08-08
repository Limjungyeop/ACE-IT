package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class InfoPage6 : AppCompatActivity() {
    var backtomenubutton2: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_page6)

        backtomenubutton2 = findViewById<View>(R.id.backtomenubutton2) as ImageButton
        backtomenubutton2!!.setOnClickListener { openMenu() }
    }
    fun openMenu() {
        val menu = Intent(this, Menu::class.java)
        startActivity(menu)
    }
}