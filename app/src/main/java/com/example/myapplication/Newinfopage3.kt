package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Newinfopage3 : AppCompatActivity() {
    var newrightbutton3: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newinfopage3)
        newrightbutton3 = findViewById(R.id.newrightbutton3)
        newrightbutton3!!.setOnClickListener {
            val gomenu = Intent(this, Menu::class.java)
            startActivity(gomenu)
        }
    }
}