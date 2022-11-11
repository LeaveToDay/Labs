package com.staynight.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.radiobutton.MaterialRadioButton
import com.staynight.lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        bindView()
    }

    private fun bindView() {
        binding?.apply {
            btnCalculate.setOnClickListener {
                if (!edtPrice.text.isNullOrEmpty()) {
                    val price = edtPrice.text.toString()
                    val resultBottomSheet = ResultBottomSheet(
                        price.toDouble(),
                        findViewById<MaterialRadioButton>(rgTips.checkedRadioButtonId).text.toString()
                            .split("%").first().toInt(),
                        tvSplitCount.text.toString().toInt()
                    )
                    resultBottomSheet.show(supportFragmentManager, resultBottomSheet.tag)
                }
            }
            btnMinus.setOnClickListener {
                var split = tvSplitCount.text.toString().toInt()
                if (tvSplitCount.text.toString().toInt() > 2)
                    tvSplitCount.text = (--split).toString()

            }
            btnPlus.setOnClickListener {
                var split = tvSplitCount.text.toString().toInt()
                tvSplitCount.text = (++split).toString()

            }
        }
    }
}