package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Newinfopage2 : AppCompatActivity() {
    var newrightbutton2: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newinfopage2)
        newrightbutton2 = findViewById(R.id.newrightbutton2)
        newrightbutton2!!.setOnClickListener {
            val opennewrightbutton2 = Intent(this, Newinfopage3::class.java)
            startActivity(opennewrightbutton2)
        }
    }
}