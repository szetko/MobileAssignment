package com.example.languagetranslatornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultsQuiz : AppCompatActivity() {
    lateinit var mFinalScore: TextView
    lateinit var mGrade: TextView
    lateinit var mRetryButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_quiz)

        //mQuestionView = findViewById<TextView>(R.id.question)
       // mButtonChoice1 = findViewById<Button>(R.id.choice1)

        mFinalScore = findViewById<TextView>(R.id.score)
        mGrade = findViewById<TextView>(R.id.outOf)
        mRetryButton = findViewById<Button>(R.id.retry)

        var bundle = getIntent().extras
        var score = bundle?.getInt("finalscore")

        mFinalScore.setText("You scored" + score + "out of 4")



    }
}
