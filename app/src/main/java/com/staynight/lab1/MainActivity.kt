package com.staynight.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.staynight.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        bindView()
        initTimer()
    }

    private fun bindView() {
        binding?.apply {
            progressBar.max = 100
        }
    }

    private fun initTimer() {
        binding?.apply {
            val timer = object : CountDownTimer(10000, 100) {
                override fun onTick(p0: Long) {
                    tvPercent.text = "${(10000 - p0) / 100}%"
                    progressBar.progress = ((10000 - p0) / 100).toInt()
                }
                override fun onFinish() {
                    flProgress.hide()
                    flIAmRich.show()
                }
            }
            timer.start()
        }
    }

    fun View.hide() {
        this.visibility = View.GONE
    }

    fun View.show() {
        this.visibility = View.VISIBLE
    }
}