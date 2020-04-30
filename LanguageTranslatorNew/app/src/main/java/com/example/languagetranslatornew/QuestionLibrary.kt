package com.example.languagetranslatornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QuestionLibrary : AppCompatActivity() {

       val mQuestions: Array<String> = arrayOf("What is my name", "What is my name 2", "Favourite color", "Favourite food", "Fill in")
       val mChoices = arrayOf<Array<String>>(arrayOf<String>("Stefan", "Ben", "brad", "Braeden"),
        arrayOf<String>("Ben", "Stefan", "Neb", "Brad"),
        arrayOf<String>("red", "green", "yellow", "blue"),
        arrayOf<String>("Chocolate", "pizza", "cheese", "key"))


    var correctAnswers: Array<String> = arrayOf("Stefan", "Stefan", "blue", "cheese")

   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_library)

    }*/

    fun getQuestion(a: Int): String {
       val question = mQuestions[a]
        return question

    }

    fun getChoice1(a: Int): String {
        val choice0 = mChoices[a] [0]
        return choice0
    }

    fun getChoice2(a: Int): String {
        val choice1 = mChoices[a] [1]
        return choice1
    }

    fun getChoice3(a: Int): String {
        val choice2 = mChoices[a] [2]
        return choice2
    }

    fun getChoice4(a: Int): String {
        val choice3 = mChoices[a] [3]
        return choice3
    }

    fun getCorrectAnswer(a: Int) : String {
        val answer = correctAnswers[a]
        return answer
  }
}
