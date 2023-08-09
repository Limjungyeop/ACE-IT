package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Newinfopage : AppCompatActivity() {
    var newrightbutton1: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newinfopage)
        newrightbutton1 = findViewById(R.id.newrightbutton1)
        newrightbutton1!!.setOnClickListener {
            val opennewrightbutton1 = Intent(this, Newinfopage2::class.java)
            startActivity(opennewrightbutton1)
        }
    }
}