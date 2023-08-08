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
        saveToRealtimeDatabase = findViewById<View>(R.id.saveToRealtimeDatabase) as ImageButton
        startbutton = findViewById<View>(R.id.startbutton) as ImageButton
        startbutton!!.setOnClickListener { openComicPage1() }
        databaseReference = FirebaseDatabase.getInstance().reference.child("Users")
        saveToRealtimeDatabase!!.setOnClickListener { insertUserData() }
    }

    fun openComicPage1() {
        val comicpage1 = Intent(this, ComicPage1::class.java)
        startActivity(comicpage1)
    }

    fun insertUserData() {
        val name = etname!!.text.toString()
        val age = etage!!.text.toString()
        val country = etcountry!!.text.toString()
        val users = Users(name, age, country)
        databaseReference!!.push().setValue(users)
        Toast.makeText(this@MainActivity, "Data inserted!", Toast.LENGTH_SHORT).show()
    }
}