
package com.example.languagetranslatornew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }




}
