package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Explanation : AppCompatActivity() {
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
        setContentView(R.layout.activity_explanation)

        close_button = findViewById(R.id.closeExplanationButton)
        close_button!!.setOnClickListener {
            val level = Intent(this, Level::class.java)
            startActivity(level)
        }

        // 저장된 레벨 불러오기
        val sharedPreferences = getSharedPreferences("app_user", Context.MODE_PRIVATE)
        userLevel = sharedPreferences.getInt("level", 1)

        //button1 click
        levelButton1 = findViewById(R.id.levelExplanationButton1)

        levelButton1.setOnClickListener {
            openQuiz(1)
        }

        //button2 click
        levelButton2 = findViewById(R.id.levelExplanationButton2)

        levelButton2.setOnClickListener {
            openQuiz(2)
        }
        //button3 click
        levelButton3 = findViewById(R.id.levelExplanationButton3)

        levelButton3.setOnClickListener {
            openQuiz(3)
        }
        //button4 click
        levelButton4 = findViewById(R.id.levelExplanationButton4)

        levelButton4.setOnClickListener {
            openQuiz(4)
        }
        //button5 click
        levelButton5 = findViewById(R.id.levelExplanationButton5)

        levelButton5.setOnClickListener {
        openQuiz(5)
        }
    }
    private fun openQuiz(checklevel:Int){
        if (userLevel <= checklevel){
            Toast.makeText(this, "Must Finish Previous Levels", Toast.LENGTH_SHORT).show()
        } else {
            val quizExplanation = Intent(this, QuizExplanation::class.java)
            quizExplanation.putExtra("quiz_level", checklevel)
            startActivity(quizExplanation)
        }
    }
}