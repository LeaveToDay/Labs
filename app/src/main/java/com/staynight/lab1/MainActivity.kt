package com.staynight.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.staynight.lab1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val randomText = listOf(
        "Пробуждение",
        "Их собственная лига",
        "Бронкская история",
        "Ангелы у кромки поля",
        "Время убивать",
        "Амистад",
        "Анаконда",
        "Прохладное сухое место",
        "Почти знаменит",
        "Анализируй это"
    )

    private val randomImages = listOf(
        R.drawable.m1,
        R.drawable.m2,
        R.drawable.m3,
        R.drawable.m4,
        R.drawable.m5,
        R.drawable.m6,
        R.drawable.m7,
        R.drawable.m8,
        R.drawable.m9,
        R.drawable.m10,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        bindView()
        setRandomMovie()
    }

    private fun bindView() {
        binding?.apply {
            btnRandom.setOnClickListener {
                setRandomMovie()
            }
        }
    }

    private fun setRandomMovie(){
        binding?.apply {
            val randomInt = Random.nextInt(10)
            ivRandom.setImageDrawable(AppCompatResources.getDrawable(root.context, randomImages[randomInt]))
            tvRandom.text = randomText[randomInt]
        }
    }
}