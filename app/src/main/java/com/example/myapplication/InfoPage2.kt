package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class InfoPage2 : AppCompatActivity() {
    var rightbutton5: ImageButton? = null
    var backtomenubutton2: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_page2)
        rightbutton5 = findViewById<View>(R.id.rightbutton5) as ImageButton
        rightbutton5!!.setOnClickListener { openInfoPage3() }
        backtomenubutton2 = findViewById<View>(R.id.backtomenubutton2) as ImageButton
        backtomenubutton2!!.setOnClickListener { openMenu() }
    }
    fun openMenu() {
        val menu = Intent(this, Menu::class.java)
        startActivity(menu)
    }
    fun openInfoPage3() {
        val infopage3 = Intent(this, InfoPage3::class.java)
        startActivity(infopage3)
    }
}