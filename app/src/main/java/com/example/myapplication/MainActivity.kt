package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    var etname: EditText? = null
    var etage: EditText? = null
    var etcountry: EditText? = null
    var saveToRealtimeDatabase: ImageButton? = null
    var databaseReference: DatabaseReference? = null
    var startbutton: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etname = findViewById(R.id.etname)
        etage = findViewById(R.id.etage)
        etcountry = findViewById(R.id.etcountry)

        databaseReference = FirebaseDatabase.getInstance().reference.child("Users")
        saveToRealtimeDatabase = findViewById<View>(R.id.saveToRealtimeDatabase) as ImageButton
        saveToRealtimeDatabase!!.setOnClickListener { insertUserData() }

        startbutton = findViewById<View>(R.id.startbutton) as ImageButton
        startbutton!!.setOnClickListener { startActivity(Intent(this, ComicPage1::class.java)) }
    }


    fun insertUserData() {
        val name = etname!!.text.toString()
        val age = etage!!.text.toString()
        val country = etcountry!!.text.toString()
        val users = Users(name, age, country) //Users activity에서 선언된 Users class사용
        databaseReference!!.push().setValue(users)
        Toast.makeText(this@MainActivity, "Data inserted!", Toast.LENGTH_SHORT).show()
    }
}