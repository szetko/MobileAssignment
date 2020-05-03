package com.example.languagetranslatornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Main Activity class
 * @property This class holds all the different questions/answers and choices used for the four quizes.
 * I set many methods in this class and implemented these methods on the chosen quizes. Basically
 * the methods created are to sort through the chosen arrays and get a new question/answer/choice for the
 * given activity. Must have been a much easier way to do so but this is the way i went with which was very
 * time consuming
 *
 */

class QuestionLibrary : AppCompatActivity() {

       val mQuestions: Array<String> = arrayOf("What is hello in Russian?", "What colour is the Russian Flag?", "What is the population of Russia", "What do Russians like?")
    val mQuestions2: Array<String> = arrayOf("What is hello in German?", "What colour is the German Flag?", "What is the population of Germany", "What do Germans like?")
    val mQuestions3: Array<String> = arrayOf("What is hello in Spanish?", "What colour is the Spanish Flag?", "What is the population of Spain", "What do Spanish people like?")
    val mQuestions4: Array<String> = arrayOf("What is hello in Japanese?", "What colour is the Japanese Flag?", "What is the population of Japan", "What do Japanese people like?")
       val mChoices = arrayOf<Array<String>>(arrayOf<String>("Hello", "Privet", "Hallo", "Gutentag"),
        arrayOf<String>("Green", "Blue", "White + Blue + red", "None"),
        arrayOf<String>("130M", "144.5M", "305M", "1BILLION"),
        arrayOf<String>("Chocolate", "pizza", "cheese", "Cookies"))
    val mChoices2 = arrayOf<Array<String>>(arrayOf<String>("Gutentag", "Go away", "Heeey", "Privet"),
        arrayOf<String>("Black + Yellow + red", "Green + blue", "Yellow + orange", "Gold + blue"),
        arrayOf<String>("10M", "105M", "80M", "83M"),
        arrayOf<String>("Chocolate", "pizza", "cheese", "Beer"))
    val mChoices3 = arrayOf<Array<String>>(arrayOf<String>("Ya", "Hallo", "Hola", "Gutentag"),
        arrayOf<String>("Green + Red", "Yellow + Blue", "Green + Black", "Green + Blue"),
        arrayOf<String>("1M", "56M", "254M", "47M"),
        arrayOf<String>("Chocolate", "pizza", "cheese", "Cookies"))
    val mChoices4 = arrayOf<Array<String>>(arrayOf<String>("Konichiwa", "Hallo", "Privet", "Hola"),
        arrayOf<String>("White", "White + Red", "White + Black", "Green"),
        arrayOf<String>("500M", "125M", "41M", "1BILLION"),
        arrayOf<String>("Chocolate", "pizza", "cheese", "Cookies"))
        //var mImages = arrayOf<Int>(R.drawable.ic_games, R.drawable.ic_home, R.drawable.ic_school)
        //var list = ArrayList<Int>(R.drawable.ic_school, R.drawable.ic_games, R.drawable.ic_home)




    var correctAnswers: Array<String> = arrayOf("Privet", "White + Blue + red", "144.5M", "cheese")
    var correctAnswers2: Array<String> = arrayOf("Gutentag", "Black + Yellow + red", "80M", "Beer")
    var correctAnswers3: Array<String> = arrayOf("Hola", "Green + Red", "47M", "Chocolate")
    var correctAnswers4: Array<String> = arrayOf("Konichiwa", "White + Red", "41M", "pizza")

   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_library)

    }*/


    fun getQuestion(a: Int): String {

       val question = mQuestions[a]
        return question

    }

    fun getQuestion2(a: Int): String {

        val question = mQuestions2[a]
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
    fun germanGetChoice1(a: Int): String {
        val choice0 = mChoices2[a] [0]
        return choice0
    }

    fun germanGetChoice2(a: Int): String {
        val choice1 = mChoices2[a] [1]
        return choice1
    }

    fun germanGetChoice3(a: Int): String {
        val choice2 = mChoices2[a] [2]
        return choice2
    }

    fun germanGetChoice4(a: Int): String {
        val choice3 = mChoices2[a] [3]
        return choice3
    }

    fun germanGetCorrectAnswer(a: Int) : String {
        val answer2 = correctAnswers2[a]
        return answer2
    }

    fun spanishGetQuestion(a: Int): String {

        val question = mQuestions3[a]
        return question

    }

    fun japGetQuestion(a: Int): String {

        val question = mQuestions4[a]
        return question

    }

    fun spanishGetChoice1(a: Int): String {
        val choice0 = mChoices3[a] [0]
        return choice0
    }

    fun spanishGetChoice2(a: Int): String {
        val choice1 = mChoices3[a] [1]
        return choice1
    }

    fun spanishGetChoice3(a: Int): String {
        val choice2 = mChoices3[a] [2]
        return choice2
    }

    fun spanishGetChoice4(a: Int): String {
        val choice3 = mChoices3[a] [3]
        return choice3
    }

    fun spanishGetCorrectAnswer(a: Int) : String {
        val answer = correctAnswers3[a]
        return answer
    }


    fun japGetChoice1(a: Int): String {
        val choice0 = mChoices4[a] [0]
        return choice0
    }

    fun japGetChoice2(a: Int): String {
        val choice1 = mChoices4[a] [1]
        return choice1
    }

    fun japGetChoice3(a: Int): String {
        val choice2 = mChoices4[a] [2]
        return choice2
    }

    fun japGetChoice4(a: Int): String {
        val choice3 = mChoices4[a] [3]
        return choice3
    }

    fun japGetCorrectAnswer(a: Int) : String {
        val answer = correctAnswers4[a]
        return answer
    }
}
