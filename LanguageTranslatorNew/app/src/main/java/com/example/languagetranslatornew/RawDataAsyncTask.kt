package com.example.languagetranslatornew

import android.content.Context
import android.os.AsyncTask
import java.net.URL

class RawDataAsyncTask (private val listener: IDataDownloadComplete, context: Context) :AsyncTask<String, Void, String>() {

    private var downloadStatus = DownloadStatus.NONE
    private var progressBar = ProgressBar(context)

   override fun onPreExecute() {
        progressBar.show()
    }

     override fun onPostExecute(result: String) {
        progressBar.dismiss()
        listener.onDownloadComplete(result, downloadStatus)
    }

    override fun doInBackground(vararg url: String?): String {
        var data = ""
        try {
            downloadStatus = DownloadStatus.OK
            data = downloadXML(url[0])
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }

    private fun downloadXML(urlPath: String?): String {
        return URL(urlPath).readText()
    }
}