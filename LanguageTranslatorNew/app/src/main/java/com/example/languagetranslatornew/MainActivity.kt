
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


class MainActivity : AppCompatActivity() {



    @Override
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        translateBtn.setOnClickListener{
            val intent = Intent(this, TranslateGame::class.java)
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



        alertBtn.setOnClickListener{
            val builder = AlertDialog.Builder(this)

            builder.setTitle("Instructions")

            builder.setIcon(R.drawable.ic_launcher_background)
            builder.setMessage("Getting started using Language Translate" +
                    "- Press the play button" +
                    "- Select a Language" +
                    "- Enter the word you would like to translate")
            builder.setPositiveButton("Ok, got it!", null)
            val dialog : AlertDialog = builder.create()
            dialog.show()

        }

        val button = findViewById<Button>(R.id.quizBtn)

        button.setOnClickListener{
            val intent = Intent(this, QuizSelection::class.java)

            startActivity(intent)
        }



        var appSettingsPrefs: SharedPreferences = getSharedPreferences("AppSettingPrefs", 0)
        val isNightModeOn: Boolean = appSettingsPrefs.getBoolean("NightMode", false)
        val sharedPrefsEdit: SharedPreferences.Editor = appSettingsPrefs.edit()

        if(isNightModeOn)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            switchBtn.text = "Disable Dark Mode"
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            switchBtn.text = "Enable Dark Mode"
        }

        switchBtn.setOnClickListener(View.OnClickListener {
            if(isNightModeOn){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPrefsEdit.putBoolean("NightMode", false)
                sharedPrefsEdit.apply()

                switchBtn.text = "Enable Dark Mode"

            }else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPrefsEdit.putBoolean("NightMode", true)
                sharedPrefsEdit.apply()

                switchBtn.text = "Disable Dark Mode"
            }

        })

    }




}
