package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Result : AppCompatActivity() {
    private lateinit var nextButton: ImageButton
    private lateinit var totalScoreText: TextView
    private lateinit var scoreText: TextView
    private lateinit var resultMessage: TextView
    private lateinit var homeButton2: ImageButton
    private lateinit var retryButton: ImageButton
    private lateinit var explanationButton: Button

    private var currentLevel: Int = 1 // 현재 레벨
    private var score: Int = 0
    private var totalscore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val intent = intent

        // 결과 표시
        val result : String? = intent.extras?.getString("result_message")
        if(result != null){
            resultMessage = findViewById(R.id.resultMessage)
            resultMessage.text = result
        }

        //스코어 표시
        score = intent.extras!!.getInt("score")
        if(score != null){
            scoreText = findViewById(R.id.scoreText)
            scoreText.text = score.toString()
        }

        //Level
        currentLevel = intent.extras!!.getInt("quiz_level")


        // 저장된 total스코어 불러오기
        val sharedPreferences1 = getSharedPreferences("app_user", Context.MODE_PRIVATE)
        var totalScore = sharedPreferences1.getInt("total_score", 0)

        // total스코어 증가 후 저장
        totalScore  += score
        val sharedPreferences = getSharedPreferences("app_user", Context.MODE_PRIVATE  )
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt("total_score",totalScore)
        editor.commit()

        // total스코어 표시
        totalScoreText = findViewById(R.id.totalscoreText)
        totalScoreText.text = "Total_Score:" + totalScore.toString()

        //홈 버튼
        homeButton2 = findViewById(R.id.homeButton2)

        homeButton2.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

        //retry 버튼
        retryButton = findViewById(R.id.retryButton)

        retryButton.setOnClickListener {

            val quiz = Intent(this, Quiz::class.java)
            quiz.putExtra("quiz_level", currentLevel)

            startActivity(quiz)
        }

        //next 버튼
        nextButton = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            startActivity(Intent(this, Level::class.java))
        }

        //next 버튼
        explanationButton = findViewById(R.id.explanationButton)
        explanationButton.setOnClickListener {
            startActivity(Intent(this, Explanation::class.java))
        }


    }
}