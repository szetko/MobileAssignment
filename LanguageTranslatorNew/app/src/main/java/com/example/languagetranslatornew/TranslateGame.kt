package com.example.languagetranslatornew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_translate_game.*

/**
 * translateGame activity
 * @property TranslateGame
 * bascially four different buttons which navigate the user to the different activites when they are clicked
 * using the intent.
 */
class TranslateGame : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate_game)

        germanButton.setOnClickListener{
            val intent = Intent(this, German::class.java)
            startActivity(intent)

        }

        japButton.setOnClickListener{
            val intent = Intent(this, Japanese::class.java)
            startActivity(intent)

        }

        spanishButton.setOnClickListener{
            val intent = Intent(this, Spanish::class.java)
            startActivity(intent)

        }

        frenchButton.setOnClickListener{
            val intent = Intent(this, French::class.java)
            startActivity(intent)

        }

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
