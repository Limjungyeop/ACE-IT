package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class InfoPage6 : AppCompatActivity() {
    var backtomenubutton5: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_page6)

        backtomenubutton5 = findViewById<View>(R.id.backtomenubutton5) as ImageButton
        backtomenubutton5!!.setOnClickListener { openMenu() }
    }
    fun openMenu() {
        val menu = Intent(this, Menu::class.java)
        startActivity(menu)
    }
}