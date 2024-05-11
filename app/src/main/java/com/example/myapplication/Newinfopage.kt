package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Newinfopage : AppCompatActivity() {
    var newrightbutton1: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newinfopage)
        newrightbutton1 = findViewById(R.id.newrightbutton1)
        newrightbutton1!!.setOnClickListener {
            startActivity(Intent(this, Newinfopage2::class.java))
        }
    }
}