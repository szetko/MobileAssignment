package com.example.languagetranslatornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_german.*
import java.util.*

class Spanish : AppCompatActivity() {
    lateinit var mTTS:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spanish)

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
        var spanish = Locale("es", "ES")


        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if(status != TextToSpeech.ERROR)
            {
                //if there is no error then set language
                mTTS.language = spanish
            }
        })

        //speak button click
        speakBtn.setOnClickListener{
            //get text from edittext field
            val toSpeak = textEt.text.toString()
            if(toSpeak == "")
            {
                //If there is no text
                Toast.makeText(this, "There is no text", Toast.LENGTH_SHORT).show()
            }
            else{
                //If there is text in edit text
                Toast.makeText(this, toSpeak, Toast.LENGTH_SHORT).show()
                mTTS.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
            }
        }
        //stop speaking button click
        stopBtn.setOnClickListener{
            if(mTTS.isSpeaking)
            {
                //if speaking then stop
                mTTS.stop()
            }
            else {
                //if not speaking
                Toast.makeText(this, "Not speaking", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onPause()
    {
        if(mTTS.isSpeaking)
        {
            mTTS.stop()
        }
        super.onPause()
    }
}
