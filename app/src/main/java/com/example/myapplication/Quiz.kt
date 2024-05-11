package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Quiz : AppCompatActivity() {
    companion object{
        const val COUNTDOWN_DURATION: Long = 30000 // 타이머 시간 (30초)
    }

    private lateinit var heart1: ImageView
    private lateinit var heart2: ImageView
    private lateinit var heart3: ImageView
    private lateinit var timerText: TextView
    private lateinit var quizLevel: TextView
    private lateinit var questionText: TextView
    private lateinit var answerGroup: RadioGroup
    private lateinit var checkButton: Button
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var optionQuiz : ImageButton

    private var currentLevelIndex: Int = 1 // 현재 레벨
    private var currentQuestionIndex: Int = 0 // 현재 문제 번호
    private var currentScore: Int = 0 //현재 스코어
    private var remainingHearts: Int = 3 // 남은 하트 개수
    private var correctAnswer: String = ""

//    private lateinit var questionSnapshot: DataSnapshot
    // Firebase Realtime Database 인스턴스와 참조
    private lateinit var database: FirebaseDatabase
    private lateinit var questionsRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        //좌상단의 이미지 옵션으로 쓰려했으나 개발이 안되 숨김
        optionQuiz = findViewById(R.id.option_quiz)
        optionQuiz.visibility = View.INVISIBLE
        heart1 = findViewById(R.id.heart1)
        heart2 = findViewById(R.id.heart2)
        heart3 = findViewById(R.id.heart3)
        timerText = findViewById(R.id.timerText)
        quizLevel = findViewById(R.id.quizLevel)
        questionText = findViewById(R.id.questionText)
        answerGroup = findViewById(R.id.answerGroup)
        checkButton = findViewById(R.id.checkButton)

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
        val levelText = "Level $level"
        this.quizLevel.text = levelText

        // 타이머 시작
        startTimer()

        // Firestore에서 문제 가져오기
        getQuestionFromDatabase()


        // 정답 확인 버튼 클릭 이벤트 처리
        checkButton.setOnClickListener {
            checkAnswer()
        }
    }
    private fun getQuestionFromDatabase() {
        questionsRef.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var questionSnapshot = dataSnapshot.child(currentLevelIndex.toString()).child((currentQuestionIndex + 1).toString())
                if (questionSnapshot.exists()) {
                    //문제가 존재하는 경우
                    currentQuestionIndex++
                    answerGroup.tag = currentQuestionIndex
                    //문제표시
                    val questionData = questionSnapshot.value as? Map<*, *>
                    if (questionData != null) {
                        val question = questionData["questionText"] as? String
                        questionText.text = question
                        viewAnswerList(questionData)
                    }
                } else {
                    closeQuiz()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("RealtimeDatabase", "Error getting next question", databaseError.toException())
            }
        })
    }
    //답변 표시
    private fun viewAnswerList(questionData:Map<*, *>){
            // 문제의 답변을 가져와서 RadioGroup에 추가합니다.
            val answers = questionData["answers"] as? List<Map<*, *>>
            if (answers != null) {
                answerGroup.removeAllViews() // 기존 답변 제거
                val inflater = LayoutInflater.from(this@Quiz)
                for (answer in answers) {
                    val radioButton = inflater.inflate(
                        R.layout.activity_quiz_radio,
                        answerGroup,
                        false
                    ) as RadioButton

                    val answerText = answer["text"] as? String
                    val isCorrect = answer["isCorrect"] as? Boolean

                    radioButton.text = answerText
                    answerGroup.addView(radioButton)

                    if (isCorrect == true) correctAnswer = answerText.toString()
                }
            }
    }
    private fun closeQuiz() {
        // 다음 문제가 없는 경우 (퀴즈 종료)
        //Toast.makeText(this@Quiz, "Quiz is complete", Toast.LENGTH_SHORT).show()
        //스코어 처리(한문제도 안틀렸을 경우 +10점)
        if (currentScore == 90){
            currentScore = 100
        }
        //userlevel 증가 및 저장
        currentLevelIndex++
        val sharedPreferences = getSharedPreferences("app_user", Context.MODE_PRIVATE  )
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt("level",currentLevelIndex)
        editor.apply()

        //스코어, 결과 문구 전달
        val resultPage = Intent(this@Quiz, Result::class.java)
        resultPage.putExtra("result_message", "GREAT JOB!")
        resultPage.putExtra("score", currentScore)
        resultPage.putExtra("quiz_level", currentLevelIndex-1)

        stopTimer()
        startActivity(resultPage)
    }
    //타이머 시작 함수, 단위는 밀리초(1/1000초)
    private fun startTimer() {
        countDownTimer = object : CountDownTimer(COUNTDOWN_DURATION, 1000) {
            //지정된 주기(1000밀리초)마다 호출됨
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerText.text = "$secondsRemaining"
            }


            override fun onFinish() {
                val finishText = "Time's up"
                timerText.text = finishText
                //정답을 맞히지 못하고 타이머가 종료된 경우
                val resultPage = Intent(this@Quiz, Result::class.java)
                resultPage.putExtra("result_message", "Try again")
                resultPage.putExtra("quiz_level", currentLevelIndex)
                startActivity(resultPage)
            }
        }.start()
    }

    private fun stopTimer() {
        countDownTimer.cancel()
    }
    private fun checkAnswer() {
//        countDownTimer.cancel() // 타이머 중지

        val selectedRadioButtonId = answerGroup.checkedRadioButtonId
        if (selectedRadioButtonId != -1) {
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            val selectedAnswer = selectedRadioButton.text.toString()
            //채점 구문
            if (selectedAnswer == correctAnswer) {
                //스코어 추가
                currentScore += 30
                // 정답일 때의 동작 추가
                Toast.makeText(this, "You are Correct!", Toast.LENGTH_SHORT).show()
                countDownTimer.start() // 타이머 재시작
                // 다음 문제 표시
                getQuestionFromDatabase()
            } else {
                //스코어 감점
                currentScore -= 10
                // 오답일 때의 동작 추가
                Toast.makeText(this, "You are Incorrect.", Toast.LENGTH_SHORT).show()

                // 하트 제거
                removeHeart()
            }

            // 채점 후 라디오 버튼 선택 초기화
            answerGroup.clearCheck()
        } else {
            Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun removeHeart() {
        when (remainingHearts) {
            3 -> {
                heart3.setImageResource(R.drawable.heart_image_empty)
                remainingHearts--
            }
            2 -> {
                heart2.setImageResource(R.drawable.heart_image_empty)
                remainingHearts--
            }
            1 -> {
                heart1.setImageResource(R.drawable.heart_image_empty)
                remainingHearts--

                // 여기서 하트가 모두 소진되면 게임 오버 등의 동작 추가 가능
                val resultPage = Intent(this@Quiz, Result::class.java)
                resultPage.putExtra("result_message", "TRY AGAIN")
                resultPage.putExtra("quiz_level", currentLevelIndex)
                stopTimer()
                startActivity(resultPage)
            }
        }
    }
}