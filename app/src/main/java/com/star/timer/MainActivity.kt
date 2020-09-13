package com.star.timer

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var handler: Handler = Handler()
    var number: Int = 0
    var runnable: Runnable = Runnable { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View) {
        runnable = object : Runnable {
            override fun run() {
                textview.text = "Timer:" + number
                number++
                textview.text = "Timer:" + number
                handler.postDelayed(this, 1000)

            }
        }
        handler.post(runnable)
    }

    fun stop(view: View) {
        handler.removeCallbacks(runnable)
        number = 0
        textview.text = "Timer:" + number

    }
}

