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
import kotlinx.android.synthetic.main.activity_french.*
import kotlinx.android.synthetic.main.activity_german.*
import org.intellij.lang.annotations.Language
import java.util.*

/**
 *
 * @property French
 * French translation activity, however using the spinner the user can actually just translate
 * any of the four languages and it wont matter which activity was selected. I used the multiple different
 * activities because it was hard to implement the text-to-speech part when using just one activity
 * for each of the different languages.
 */

class French : AppCompatActivity(), IDataDownloadAvailable,
IDataDownloadComplete {


    private lateinit var rawDataAsyncTask: RawDataAsyncTask

    lateinit var mTTS: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_french)
        /**
         * Gets string array from the array's folder and looks through the array to populate the spinner
         * used with the different languages set.
         */

        val languages: Array<String> = resources.getStringArray(R.array.languages)
        populateSpinner(spinLang, languages)

        /**
         * Taken from graysons code
         */
        btnLang.setOnClickListener {
            val fromLang = "en-"
            val language = LanguageClass()
            val toLang: String = language.code(spinLang.selectedItem.toString())
            val formatLang: String = fromLang + toLang
            val url: String = createURI(
                "https://translate.yandex.net/api/v1.5/tr.json/translate",
                "trnsl.1.1.20200502T010558Z.6bae7f1e6af0e895.700691dd37b0367d9db73b4f093e69b875caa5de",
                edtTxtLang.text.toString(), formatLang
            )
            rawDataAsyncTask = RawDataAsyncTask(this, this@French)
            rawDataAsyncTask.execute(url)
        }
    }

    /**
     * Populate the spinner
     */
    private fun populateSpinner(spinner: Spinner, array: Array<String>){
        val layoutID: Int = android.R.layout.simple_spinner_item
        spinner.adapter = ArrayAdapter(this@French, layoutID, array)
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
        Log.d("French", "onDataAvailable - {data}")
        txtVLang.text = data
    }

    override fun onError(e: Exception) {
        Log.d("French", "onError = {e.message}")
    }

    override fun onDownloadComplete(data: String, status: DownloadStatus) {
        if (status == DownloadStatus.OK) {
            val yandexAsyncTask = YandexAsyncTask(this)
            yandexAsyncTask.execute(data)
        }


        quit1.setOnClickListener{

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

        /**
         * Text to speech, using if statements checking if there is an error with the application,
         * if not then set the lanaguage to the chosen Locale
         */

        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if(status != TextToSpeech.ERROR)
            {
                //if there is no error then set language
                mTTS.language = Locale.FRENCH
            }
        })

        //speak button click
        speakBtn1.setOnClickListener{
            //get text from edittext field
            val toSpeak = txtVLang.text.toString()
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
        stopBtn1.setOnClickListener{
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

    /**
     * To stop the speech when it is running, being implemented on the stop button
     */
    override fun onPause()
    {
        if(mTTS.isSpeaking)
        {
            mTTS.stop()
        }
        super.onPause()
    }
}
