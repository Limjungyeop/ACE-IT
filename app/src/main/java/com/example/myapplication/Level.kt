package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast

class Level : AppCompatActivity() {
    var close_button: ImageButton? = null

    private lateinit var levelButton1: ImageButton
    private lateinit var levelButton2: ImageButton
    private lateinit var levelButton3: ImageButton
    private lateinit var levelButton4: ImageButton
    private lateinit var levelButton5: ImageButton
    // 유저 레벨
    private var userLevel: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        close_button = findViewById(R.id.close_button)
        close_button!!.setOnClickListener {
                val menu1 = Intent(this, Menu::class.java)
                startActivity(menu1)
        }

        // 저장된 레벨 불러오기
        val sharedPreferences = getSharedPreferences("app_user", Context.MODE_PRIVATE)
        userLevel = sharedPreferences.getInt("level", 1)

        //button1 click
        levelButton1 = findViewById(R.id.levelButton1)

        levelButton1.setOnClickListener {
            if (userLevel < 1){
                Toast.makeText(this, "Must Finish Previous Levels", Toast.LENGTH_SHORT).show()
            } else {
                val quiz = Intent(this, Quiz::class.java)
                quiz.putExtra("quiz_level", 1)
                startActivity(quiz)

            }
        }

        //button2 click
        levelButton2 = findViewById(R.id.levelButton2)

        levelButton2.setOnClickListener {
            if (userLevel < 2){
                Toast.makeText(this, "Must Finish Previous Levels", Toast.LENGTH_SHORT).show()
            } else {
                val quiz = Intent(this, Quiz::class.java)
                quiz.putExtra("quiz_level", 2)
                startActivity(quiz)
            }
        }
        //button3 click
        levelButton3 = findViewById(R.id.levelButton3)

        levelButton3.setOnClickListener {
            if (userLevel < 3){
                Toast.makeText(this, "Must Finish Previous Levels", Toast.LENGTH_SHORT).show()
            } else {
                val quiz = Intent(this, Quiz::class.java)
                quiz.putExtra("quiz_level", 3)
                startActivity(quiz)
            }
        }
        //button4 click
        levelButton4 = findViewById(R.id.levelButton4)

        levelButton4.setOnClickListener {
            if (userLevel < 4){
                Toast.makeText(this, "Must Finish Previous Levels", Toast.LENGTH_SHORT).show()
            } else {
                val quiz = Intent(this, Quiz::class.java)
                quiz.putExtra("quiz_level", 4)
                startActivity(quiz)
            }
        }
        //button5 click
        levelButton5 = findViewById(R.id.levelButton5)

        levelButton5.setOnClickListener {
            if (userLevel < 5){
                Toast.makeText(this, "Must Finish Previous Levels", Toast.LENGTH_SHORT).show()
            } else {
                val quiz = Intent(this, Quiz::class.java)
                quiz.putExtra("quiz_level", 5)
                startActivity(quiz)
            }
        }

    }
//    private fun checkLevel(level:Int) {
//        if userLevel()
//    }
}