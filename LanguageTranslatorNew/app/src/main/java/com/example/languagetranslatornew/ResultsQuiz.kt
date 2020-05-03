package com.example.languagetranslatornew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_results_quiz.*

/**
 * Main Activity class
 * @property ResultsQuiz
 * Results activity shown when a user completes the quiz. Shows the score from the quiz which
 * the getExtras was used from the quiz to pass the information to this activity to show the score.
 * Basically just navigates the user back home or to try another quiz when the buttons are selected.
 */

class ResultsQuiz : AppCompatActivity() {
   // lateinit var mFinalScore: TextView
   // lateinit var mGrade: TextView
  //  lateinit var mRetryButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results_quiz)


        val mFinalScore = findViewById<TextView>(R.id.outOf)
        val scoreName = intent.getIntExtra("finalscore", 0)


        mFinalScore.text = "You scored " +scoreName+" out of 4!"

        retry.setOnClickListener{
            val intent2 = Intent(this, QuizSelection::class.java)


            startActivity(intent2)
        }

        home.setOnClickListener{
            val intent3 = Intent(this, MainActivity::class.java)
            startActivity(intent3)
        }

    }
}
