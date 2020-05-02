package com.example.languagetranslatornew

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONArray
import org.json.JSONObject

    class YandexAsyncTask(private val listener: IDataDownloadAvailable) :
        AsyncTask<String, Void, String>() {

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            listener.onDataAvailable(result)
        }

        override fun doInBackground(vararg url: String?): String {
            var text = ""
            try {
                val jsonData = JSONObject(url[0])
                val textArr: JSONArray = jsonData.getJSONArray("text")
                text = textArr.getString(0)
            } catch (e: Exception) {
                cancel(true)
                listener.onError(e)
            }
            return text
        }
    }
