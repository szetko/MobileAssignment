package com.example.languagetranslatornew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_quiz_selection.*

/**
 * Main Activity class
 * @property QuizSelection
 * Activity which holds all the different buttons which send the user to the chosen activities when selected.
 */
class QuizSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_selection)

        germanQuiz.setOnClickListener{
            val intent = Intent(this, GermanQuiz::class.java)
            startActivity(intent)
        }

        japaneseQuiz.setOnClickListener{
            val intent = Intent(this, JapaneseQuiz::class.java)
            startActivity(intent)

        }

        russianQuiz.setOnClickListener{
            val intent = Intent(this, RussianQuiz::class.java)
            startActivity(intent)

        }

        spanishQuiz.setOnClickListener{
            val intent = Intent(this, SpanishQuiz::class.java)
            startActivity(intent)
        }

        /**
         * Code to apply the logic for the bottom navigation bar which is used in 3 of the applications
         * activities. Uses a when statements to sort through and check if either home, quiz or translate have been clicked.
         * If either have been clicked then create a new intent and take the user to this activity.
         */
        val navigation = BottomNavigationView.OnNavigationItemSelectedListener { item->
            when (item.itemId)
            {R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
                R.id.quiz -> {
                    val intent = Intent(this, QuizSelection::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.TranslateGame -> {
                    val intent = Intent(this, TranslateGame::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation)


    }
}
