package com.example.languagetranslatornew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_russian_quiz.view.*

class RussianQuiz : AppCompatActivity() {

    lateinit var mScoreView:TextView
    lateinit var mQuestionView:TextView
    private val mQuestionLibrary = QuestionLibrary()
    lateinit var mButtonChoice1:Button
    lateinit var mButtonChoice2:Button
    lateinit var mButtonChoice3:Button
    lateinit var mButtonChoice4:Button
    var mScore = 0
    var mAnswer = ""
    var mQuestionNumber = 0
    lateinit var qNum:TextView
    var qNum2 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_russian_quiz)



       // val mScoreView:TextView

        qNum = findViewById<TextView>(R.id.qNumber)
        mScoreView = findViewById<TextView>(R.id.score)
        mQuestionView = findViewById<TextView>(R.id.question)
        mButtonChoice1 = findViewById<Button>(R.id.choice1)
        mButtonChoice2 = findViewById<Button>(R.id.choice2)
        mButtonChoice3 = findViewById<Button>(R.id.choice3)
        mButtonChoice4 = findViewById<Button>(R.id.choice4)

        updateScore(mScore)
        updateqNum(qNum2)

        //Start of Button listener for Button1
        mButtonChoice1.setOnClickListener{



            if (mButtonChoice4.getText() === mAnswer)
            {
                mScore++
                qNum2++
                updateScore(mScore)
                updateqNum(qNum2)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    val intent = Intent(this, ResultsQuiz::class.java)
                    var bundle = Bundle()
                    bundle.putInt("finalscore", mScore)
                    intent.putExtras(bundle)
                    this.finish()
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
                // this line of code is optional

            } else {
                qNum2++
                updateqNum(qNum2)
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    val intent = Intent(this, ResultsQuiz::class.java)
                    var bundle = Bundle()
                    bundle.putInt("finalscore", mScore)
                    intent.putExtras(bundle)
                    this.finish()
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
            }


        }
        //Start of button choice 2
        mButtonChoice2.setOnClickListener{


            if (mButtonChoice4.getText() === mAnswer)
            {
                mScore++
                qNum2++
                updateScore(mScore)
                updateqNum(qNum2)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    val intent = Intent(this, ResultsQuiz::class.java)
                    var bundle = Bundle()
                    bundle.putInt("finalscore", mScore)
                    intent.putExtras(bundle)
                    this.finish()
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
                // this line of code is optional

            } else {
                qNum2++
                updateqNum(qNum2)
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    val intent = Intent(this, ResultsQuiz::class.java)
                    var bundle = Bundle()
                    bundle.putInt("finalscore", mScore)
                    intent.putExtras(bundle)
                    this.finish()
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
            }


        }
        //Start of button choice 3
        mButtonChoice3.setOnClickListener{

            if (mButtonChoice4.getText() === mAnswer)
            {
                mScore++
                qNum2++
                updateScore(mScore)
                updateqNum(qNum2)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    val intent = Intent(this, ResultsQuiz::class.java)
                    var bundle = Bundle()
                    bundle.putInt("finalscore", mScore)
                    intent.putExtras(bundle)
                    this.finish()
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
                // this line of code is optional

            } else {
                qNum2++
                updateqNum(qNum2)
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    val intent = Intent(this, ResultsQuiz::class.java)
                    var bundle = Bundle()
                    bundle.putInt("finalscore", mScore)
                    intent.putExtras(bundle)
                    this.finish()
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
            }


        }

        mButtonChoice4.setOnClickListener{

            if (mButtonChoice4.getText() === mAnswer)
            {
                mScore++
                qNum2++
                updateScore(mScore)
                updateqNum(qNum2)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    val intent = Intent(this, ResultsQuiz::class.java)
                   var bundle = Bundle()
                    bundle.putInt("finalscore", mScore)
                    intent.putExtras(bundle)
                    this.finish()
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
                // this line of code is optional

            } else {
                qNum2++
                updateqNum(qNum2)
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    val intent = Intent(this, ResultsQuiz::class.java)
                    var bundle = Bundle()
                    bundle.putInt("finalscore", mScore)
                    intent.putExtras(bundle)
                    this.finish()
                    startActivity(intent)
                }
                else {
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
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber))
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber)
            mQuestionNumber++



    }

    fun updateScore(point:Int)
    {
        mScoreView.setText("" + mScore)
    }

    fun updateqNum(point:Int)
    {
        qNum.setText("" + qNum2)
    }

}
