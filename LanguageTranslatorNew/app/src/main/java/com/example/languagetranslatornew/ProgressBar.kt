package com.example.languagetranslatornew

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View

/**
 * Main Activity class
 * @property ProgressBar
 * Code used from Graysons application, this shows a custom progress bar which is shown when the applicaiton
 * is translating the text-to-text translation.
 */
class ProgressBar(context: Context) {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val view: View = inflater.inflate(R.layout.activity_progress_bar, null)
    private val dialog = Dialog(context, R.style.CustomProgressBarTheme)

    fun show() {
        dialog.setContentView(view)
        dialog.show()
    }

    fun dismiss() {
        dialog.dismiss()
    }
}