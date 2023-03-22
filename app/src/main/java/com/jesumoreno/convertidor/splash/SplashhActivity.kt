package com.jesumoreno.convertidor.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jesumoreno.convertidor.R
import com.jesumoreno.convertidor.databinding.ActivitySplashhBinding
import com.jesumoreno.convertidor.signup.SignUpActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashhActivity : AppCompatActivity() {
    private lateinit var splashhBinding: ActivitySplashhBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashhBinding= ActivitySplashhBinding.inflate(layoutInflater)
        val  view =splashhBinding.root
        setContentView(view)

        val timer = Timer()
        timer.schedule(
            timerTask {
                val intent = Intent(this@SplashhActivity, SignUpActivity::class.java)
                startActivity(intent)
                finish()
            }, 1000
        )

    }



    override fun onStart() {
        super.onStart()
        Log.d("onStart","OK")
    }
    override fun onResume() {
        super.onResume()
        Log.d("onResume","OK")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause","OK")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop","OK")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart","OK")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","OK")
    }
}