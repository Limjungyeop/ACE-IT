package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class InfoPage3 : AppCompatActivity() {
    var rightbutton6: ImageButton? = null
    var backtomenubutton3: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_page3)
        rightbutton6 = findViewById<View>(R.id.rightbutton6) as ImageButton
        rightbutton6!!.setOnClickListener { openInfoPage4() }
        backtomenubutton3 = findViewById<View>(R.id.backtomenubutton3) as ImageButton
        backtomenubutton3!!.setOnClickListener { openMenu() }
    }
    fun openMenu() {
        val menu = Intent(this, Menu::class.java)
        startActivity(menu)
    }
    fun openInfoPage4() {
        val infopage4 = Intent(this, InfoPage4::class.java)
        startActivity(infopage4)
    }
}