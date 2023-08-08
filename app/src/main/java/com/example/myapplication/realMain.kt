package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class realMain : AppCompatActivity() {
    var signupButton: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)
        signupButton = findViewById<View>(R.id.signupButton) as ImageButton
        signupButton!!.setOnClickListener { openMain() }
    }

    fun openMain() {
        val signIn = Intent(this, MainActivity::class.java)
        startActivity(signIn)
    }


}