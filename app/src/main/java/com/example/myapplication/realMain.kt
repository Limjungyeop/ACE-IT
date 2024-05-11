package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class realMain : AppCompatActivity() {
    var signupButton: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)
        signupButton = findViewById<View>(R.id.signupButton) as ImageButton
        signupButton!!.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
    }



}