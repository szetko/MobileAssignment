package com.example.languagetranslatornew

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_spanish_quiz.*

class SpanishQuiz : AppCompatActivity() {
  /*  lateinit var mScoreView:TextView
    lateinit var mQuestionView:TextView
    private val mQuestionLibrary = QuestionLibrary()
    lateinit var mButtonChoice1:Button
    lateinit var mButtonChoice2:Button
    lateinit var mButtonChoice3:Button
    var mScore = 0

   var mAnswer = ""
    var mQuestionNumber = 0


  */  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spanish_quiz)

/*        updateQuestion()


       // val mScoreView:TextView


        mScoreView = findViewById(R.id.score) as TextView
        mQuestionView = findViewById(R.id.question) as TextView
        mButtonChoice1 = findViewById(R.id.choice1) as Button
        mButtonChoice2 = findViewById(R.id.choice1) as Button
        mButtonChoice3 = findViewById(R.id.choice1) as Button

        //Start of Button listener for Button1
        mButtonChoice1.setOnClickListener{
            @Override
            fun onClick(view:View)
            {
                if (mButtonChoice1.getText() === mAnswer)
                {
                    mScore + 1
                    updateScore(mScore)
                    updateQuestion()
                    // this line of code is optional
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                    updateQuestion()
                }
            }

        }
        //Start of button choice 2
        mButtonChoice2.setOnClickListener{
            @Override
            fun onClick(view:View)
            {
                if (mButtonChoice2.getText() === mAnswer)
                {
                    mScore + 1
                    updateScore(mScore)
                    updateQuestion()
                    // this line of code is optional
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                    updateQuestion()
                }
            }

        }
        //Start of button choice 3
        mButtonChoice3.setOnClickListener{
            @Override
            fun onClick(view:View)
            {
                if (mButtonChoice3.getText() === mAnswer)
                {
                    mScore + 1
                    updateScore(mScore)
                    updateQuestion()
                    // this line of code is optional
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                    updateQuestion()
                }
            }

        }


    }

    fun updateQuestion()
    {
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber))
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber))
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber))
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber))
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber)
        mQuestionNumber++
    }

    fun updateScore(point:Int)
    {
        mScoreView.setText("" + mScore)
 */   }
}
