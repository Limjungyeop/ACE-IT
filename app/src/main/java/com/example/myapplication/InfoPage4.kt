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
        rightbutton7!!.setOnClickListener { openInfoPage5() }
    }

    fun openInfoPage5() {
        val infopage5 = Intent(this, InfoPage5::class.java)
        startActivity(infopage5)
    }
}