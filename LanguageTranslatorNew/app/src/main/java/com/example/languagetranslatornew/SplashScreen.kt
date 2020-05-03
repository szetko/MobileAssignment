package com.example.languagetranslatornew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*
import java.lang.Exception

/**
 * Splashscreen activity
 * @property SplashScreen
 * Shows a image with a animation that rotates the image back and forth 360degrees.
 */
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val animation_1 = AnimationUtils.loadAnimation(baseContext, R.anim.rotate)
        val animation_2 = AnimationUtils.loadAnimation(baseContext, R.anim.anti_rotate)
        val animation_3 = AnimationUtils.loadAnimation(baseContext, R.anim.abc_fade_out)

        imageView.startAnimation(animation_2)

        animation_2.setAnimationListener(object : Animation.AnimationListener
        {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                imageView.startAnimation(animation_1)
            }

            override fun onAnimationStart(animation: Animation?) {

            }

        })

        animation_1.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                imageView.startAnimation(animation_3)
                finish()
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
            }

            override fun onAnimationStart(animation: Animation?) {
            }

        })


        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(5000)

                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                } catch(e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
