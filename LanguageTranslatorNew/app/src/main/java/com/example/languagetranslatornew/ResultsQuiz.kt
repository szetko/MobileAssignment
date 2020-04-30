package com.example.languagetranslatornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultsQuiz : AppCompatActivity() {
   // lateinit var mFinalScore: TextView
   // lateinit var mGrade: TextView
  //  lateinit var mRetryButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_quiz)


        val mFinalScore = findViewById<TextView>(R.id.outOf)
        val scoreName = intent.getIntExtra("finalscore", 0)


        mFinalScore.text = "Score:" +scoreName+"out of 4"




    }
}
