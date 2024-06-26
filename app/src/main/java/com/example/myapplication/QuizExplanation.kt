package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class QuizExplanation : AppCompatActivity() {

    private lateinit var quizLevel: TextView
    private lateinit var questionText: TextView
    private lateinit var answerExpText: TextView
    private lateinit var explanationText: TextView
    private lateinit var closeExpButton: ImageButton
    private lateinit var rightExpButton: ImageButton

    private var currentLevelIndex: Int = 1 // 현재 레벨
    private var currentQuestionIndex: Long = 0 // 현재 문제 번호

    // Firebase Realtime Database 인스턴스와 참조
    private lateinit var database: FirebaseDatabase
    private lateinit var questionsRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_explanation)
        fun openComicPage1() {
            val Menu = Intent(this, Menu::class.java)
            startActivity(Menu)
        }

        quizLevel = findViewById(R.id.quizExpLevel)
        questionText = findViewById(R.id.questionExpText)
        answerExpText = findViewById(R.id.answerExpText)
        explanationText = findViewById(R.id.explanationText)
        closeExpButton = findViewById(R.id.closeExpButton)
        rightExpButton = findViewById(R.id.rightExpButton)

        // Firebase Realtime Database 초기화
        database = FirebaseDatabase.getInstance()
        questionsRef = database.getReference("Questions")

        // level받기
        val intent = intent
        val level : Int? = intent.extras?.getInt("quiz_level")
        if(level != null){
//            Log.d("jylimps", userLevel)
            currentLevelIndex = level
        }
        //level 표시하기
        quizLevel.text = "Level " + level

        // Firestore에서 문제 가져오기
        getQuestionFromDatabase()

        //closeExpButton click
        closeExpButton.setOnClickListener {
            startActivity(Intent(this, Explanation::class.java))
        }

        //next 버튼
        rightExpButton.setOnClickListener {
            getQuestionFromDatabase()
        }

    }
    private fun getQuestionFromDatabase() {
        questionsRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val nextQuestionSnapshot = dataSnapshot.child(currentLevelIndex.toString()).child((currentQuestionIndex + 1).toString())
                if (nextQuestionSnapshot.exists()) {
                    // 다음 문제가 존재하는 경우
                    currentQuestionIndex++
                    answerExpText.tag = currentQuestionIndex

                    val questionData = nextQuestionSnapshot.value as? Map<*, *>
                    if (questionData != null) {
                        //문제를 표시한다
                        val question = questionData["questionText"] as? String
                        questionText.text = question
                        //문제해설을 표시한다.
                        val explanation = questionData["explanationText"] as? String
                        explanationText.text = explanation

                        // 문제의 답을 표시한다
                        val answers = questionData["answers"] as? List<Map<*, *>>
                        if (answers != null) {
                            for (answer in answers) {
                                val answerText = answer["text"] as? String
                                val isCorrect = answer["isCorrect"] as? Boolean

                                if (isCorrect == true) {
                                    answerExpText.text = "Correct Answer is : " + answerText
                                }
                            }
                        }
                    }
                } else {
                    // 다음 문제가 없는 경우 (퀴즈 종료)
                    val rightExpButton = findViewById<ImageButton>(R.id.rightExpButton)
                    rightExpButton.visibility = View.INVISIBLE

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("RealtimeDatabase", "Error getting next question", databaseError.toException())
            }
        })
    }

}