package com.example.languagetranslatornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LanguageClass {
    fun code(lang: String): String {
        return when(lang) {
            "French" -> "fr"
            "Japanese" -> "ja"
            "Spanish" -> "es"
            "German" -> "de"
            else -> "en"
        }
    }
}