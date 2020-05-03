package com.example.languagetranslatornew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_japanese_quiz.*

/**
 * Main Activity class
 * @property JapaneseQuiz
 * Uses the Question library to populate the multiple buttons and text views to display a four question quiz
 *
 */

class JapaneseQuiz : AppCompatActivity() {

    lateinit var mScoreView: TextView
    lateinit var mQuestionView: TextView
    private val mQuestionLibrary = QuestionLibrary()
    lateinit var mButtonChoice1: Button
    lateinit var mButtonChoice2: Button
    lateinit var mButtonChoice3: Button
    lateinit var mButtonChoice4: Button
    lateinit var image: ImageView
    var mScore = 0
    var mAnswer = ""
    var mQuestionNumber = 0
    lateinit var qNum: TextView
    var qNum2 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_japanese_quiz)

        /**
         * Alert dialog used to check if user wants to exit, this is implemented across multiple activities.
         */

        quit.setOnClickListener{

            //define our theme
            val builder2 = AlertDialog.Builder(this)

            builder2.setTitle("Exit")

            builder2.setIcon(R.drawable.ic_launcher_background)

            builder2.setMessage("Are you sure, you want to exit?")

            builder2.setPositiveButton("Yes") {dialog, which ->
                finish()
            }

            builder2.setNegativeButton("No") {dialog, which ->
                Toast.makeText(this, "You chose not to exit", Toast.LENGTH_LONG).show()
            }
            val dialog : AlertDialog = builder2.create()

            dialog.show()
        }



        // val mScoreView:TextView

        /**
         * binds the following variables to the Id's set on the buttons and textviews
         */

        qNum = findViewById<TextView>(R.id.qNumber)
        mScoreView = findViewById<TextView>(R.id.score)
        mQuestionView = findViewById<TextView>(R.id.question)
        mButtonChoice1 = findViewById<Button>(R.id.choice1)
        mButtonChoice2 = findViewById<Button>(R.id.choice2)
        mButtonChoice3 = findViewById<Button>(R.id.choice3)
        mButtonChoice4 = findViewById<Button>(R.id.choice4)

        /**
         * Calls the different methods set I used these to sort through the different value on the arrays created
         *
         */

        updateScore(mScore)
        updateqNum(qNum2)
        updateQuestion()

        //Start of Button listener for Button1
        mButtonChoice1.setOnClickListener{

            /**
             * If the selected button is the correct answer then update the score
             * and also check if the qNum variable = 4. If it does then this is the end of the quiz
             * and it will then display the new activity which is Results Quiz. If its not the end of the quiz
             * then update the question and carry on. I set this logic for each of the choice buttons
             * which is alot of code but it worked.
             */

            if (mButtonChoice1.getText() === mAnswer)
            {
                mScore++
                qNum2++
                updateScore(mScore)
                updateqNum(qNum2)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    Thread.sleep(200)
                    val intent = Intent(this, ResultsQuiz::class.java)
                    intent.putExtra("finalscore",mScore)
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
                    Thread.sleep(200)
                    val intent = Intent(this, ResultsQuiz::class.java)
                    intent.putExtra("finalscore",mScore)
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
            }


        }
        //Start of button choice 2
        mButtonChoice2.setOnClickListener{


            if (mButtonChoice2.getText() === mAnswer)
            {
                mScore++
                qNum2++
                updateScore(mScore)
                updateqNum(qNum2)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    Thread.sleep(200)
                    val intent = Intent(this, ResultsQuiz::class.java)
                    intent.putExtra("finalscore",mScore)
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
                    Thread.sleep(200)
                    val intent = Intent(this, ResultsQuiz::class.java)
                    intent.putExtra("finalscore",mScore)
                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
            }


        }
        //Start of button choice 3
        mButtonChoice3.setOnClickListener{

            if (mButtonChoice3.getText() === mAnswer)
            {
                mScore++
                qNum2++
                updateScore(mScore)
                updateqNum(qNum2)
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                if(qNum2 == 4)
                {
                    Thread.sleep(200)


                    val intent = Intent(this, ResultsQuiz::class.java)
                    intent.putExtra("finalscore",mScore)
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
                    Thread.sleep(200)
                    val intent = Intent(this, ResultsQuiz::class.java)
                    intent.putExtra("finalscore",mScore)
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
                    Thread.sleep(200)
                    val intent = Intent(this, ResultsQuiz::class.java)
                    intent.putExtra("finalscore",mScore)
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
                    Thread.sleep(200)
                    val intent = Intent(this, ResultsQuiz::class.java)
                    intent.putExtra("finalscore",mScore)

                    startActivity(intent)
                }
                else {
                    updateQuestion()
                }
            }


        }


    }

    /**
     * Update question method where the question and choices are set to the text. It gets the getChoice
     * and GetQuestions from the question library class where multiple methods are sent to gather
     * the information to find to the button or textviews.
     */

    fun updateQuestion()
    {


        mQuestionView.setText(mQuestionLibrary.japGetQuestion(mQuestionNumber))
        mButtonChoice1.setText(mQuestionLibrary.japGetChoice1(mQuestionNumber))
        mButtonChoice2.setText(mQuestionLibrary.japGetChoice2(mQuestionNumber))
        mButtonChoice3.setText(mQuestionLibrary.japGetChoice3(mQuestionNumber))
        mButtonChoice4.setText(mQuestionLibrary.japGetChoice4(mQuestionNumber))
        mAnswer = mQuestionLibrary.japGetCorrectAnswer(mQuestionNumber)
        // image = mQuestionLibrary.getImage()
        mQuestionNumber++



    }

    fun updateScore(point:Int)
    {
        mScoreView.setText("" + mScore)
    }

    /**
     * I set a qNum because i was having difficulties getting the application to show the results
     * screen when question 4 had been completed. I ended up hiding the textview for this on the activity
     * once i found the right code to use.
     */
    fun updateqNum(point:Int)
    {
        qNum.setText("" + qNum2)
    }


}

