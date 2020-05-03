package com.example.languagetranslatornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Main Activity class
 * @property LanguageClass
 * Set the multiple different languages here for the yandex API to implement - I took this code
 * from graysons application and changed the languages that i needed for my application.
 */
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