
package com.example.languagetranslatornew

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main Activity class
 * @property MainActivity
 * @param MainActivity
 * Navigation to main activities of the application
 */

class MainActivity : AppCompatActivity() {



    @Override
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        translateBtn.setOnClickListener{
            val intent = Intent(this, TranslateGame::class.java)
            startActivity(intent)

        }
        /**
         * Navigation Bar check which part of the navigation bar is clicked, with the intent started
         * upon clicking on the icons.
         */
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

        /**
         * Alert dialog to display when the quit button has been clicked
         */
        quit.setOnClickListener{

            //define our theme
            val builder2 = AlertDialog.Builder(this)

            builder2.setTitle("Exit")

            builder2.setIcon(R.drawable.ic_launcher_background)

            builder2.setMessage("Are you sure, you want to exit?")

            builder2.setPositiveButton("Yes") {dialog, which ->
                finishAffinity()
            }

            builder2.setNegativeButton("No") {dialog, which ->
                Toast.makeText(this, "You chose not to exit", Toast.LENGTH_LONG).show()
            }
            val dialog : AlertDialog = builder2.create()

            dialog.show()
        }

        /**
         * Alertdialog for when the how to play button is clicked to display the message below
         */

        alertBtn.setOnClickListener{
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Instructions")

            builder.setIcon(R.drawable.ic_launcher_background)
            builder.setMessage("Getting started using Language Translate\n" +
                    "- Press the Quiz button and select a quiz\n" +
                    "- Press Translate and enter a word to translate\n")
            builder.setPositiveButton("Ok, got it!", null)
            val dialog : AlertDialog = builder.create()
            dialog.show()

        }

        val button = findViewById<Button>(R.id.quizBtn)

        button.setOnClickListener{
            val intent = Intent(this, QuizSelection::class.java)

            startActivity(intent)
        }

        /**
         * Config to set the night and day mode for applicaiton
         * checks if night mode is on to swap text to Day mode and vice versa
         */

        var appSettingsPrefs: SharedPreferences = getSharedPreferences("AppSettingPrefs", 0)
        val isNightModeOn: Boolean = appSettingsPrefs.getBoolean("NightMode", false)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingsPrefs.edit()

        if(isNightModeOn)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            switchBtn.text = "Day Mode"
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            switchBtn.text = "Night Mode"
        }

        switchBtn.setOnClickListener(View.OnClickListener {
            if(isNightModeOn){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefsEdit.putBoolean("NightMode", false)
                sharedPrefsEdit.apply()

                switchBtn.text = "Night Mode"

            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPrefsEdit.putBoolean("NightMode", true)
                sharedPrefsEdit.apply()

                switchBtn.text = "Day Mode"
            }

        })

    }




}
