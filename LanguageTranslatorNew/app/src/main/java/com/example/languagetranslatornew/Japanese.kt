package com.example.languagetranslatornew

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_german.*
import kotlinx.android.synthetic.main.activity_japanese.*
import kotlinx.android.synthetic.main.activity_japanese_quiz.*
import kotlinx.android.synthetic.main.activity_japanese_quiz.quit
import java.util.*

class Japanese : AppCompatActivity(), IDataDownloadAvailable,
    IDataDownloadComplete {


    private lateinit var rawDataAsyncTask: RawDataAsyncTask

    lateinit var mTTS: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_japanese)

        val languages: Array<String> = resources.getStringArray(R.array.languages)
        populateSpinner(spinLang3, languages)

        btnLang3.setOnClickListener {
            val fromLang = "en-"
            val language = LanguageClass()
            val toLang: String = language.code(spinLang3.selectedItem.toString())
            val formatLang: String = fromLang + toLang
            val url: String = createURI(
                "https://translate.yandex.net/api/v1.5/tr.json/translate",
                "trnsl.1.1.20200502T010558Z.6bae7f1e6af0e895.700691dd37b0367d9db73b4f093e69b875caa5de",
                edtTxtLang3.text.toString(), formatLang
            )
            rawDataAsyncTask = RawDataAsyncTask(this, this@Japanese)
            rawDataAsyncTask.execute(url)
        }
    }

    private fun populateSpinner(spinner: Spinner, array: Array<String>){
        val layoutID: Int = android.R.layout.simple_spinner_item
        spinner.adapter = ArrayAdapter(this@Japanese, layoutID, array)
    }

    private fun createURI(
        baseURL: String, key: String, text: String,
        lang: String
    ): String {
        return Uri.parse(baseURL)
            .buildUpon()
            .appendQueryParameter("key", key)
            .appendQueryParameter("text", text)
            .appendQueryParameter("lang", lang)
            .build().toString()
    }
    override fun onDataAvailable(data: String) {
        Log.d("Japanese", "onDataAvailable - {data}")
        txtVLang3.text = data
    }

    override fun onError(e: Exception) {
        Log.d("Japanese", "onError = {e.message}")
    }

    override fun onDownloadComplete(data: String, status: DownloadStatus) {
        if (status == DownloadStatus.OK) {
            val yandexAsyncTask = YandexAsyncTask(this)
            yandexAsyncTask.execute(data)
        }


        quit3.setOnClickListener{

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



        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if(status != TextToSpeech.ERROR)
            {
                //if there is no error then set language
                mTTS.language = Locale.JAPANESE
            }
        })

        //speak button click
        speakBtn3.setOnClickListener{
            //get text from edittext field
            val toSpeak = txtVLang3.text.toString()
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
        stopBtn3.setOnClickListener{
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
