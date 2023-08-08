package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class InfoPage4 : AppCompatActivity() {
    var rightbutton7: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_page4)
        rightbutton7 = findViewById<View>(R.id.rightbutton7) as ImageButton
        rightbutton7!!.setOnClickListener { openInfoPage6 () }
    }

    fun openInfoPage6() {
        val infopage6 = Intent(this, InfoPage6::class.java)
        startActivity(infopage6)
    }
}