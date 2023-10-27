package com.example.dinnerdecider

import com.example.dinnerdecider.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val foodChoices = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        decideRandomFood()
        binding.btnAddFood.setOnClickListener {
            if(binding.etNewFood.text.isNotBlank())
                foodChoices.add(binding.etNewFood.text.toString())
        }
        binding.btnDecide.setOnClickListener {
            decideRandomFood()
        }
    }

    fun decideRandomFood() {
        val randomIndex = Random.nextInt(foodChoices.size)
        binding.tvDecidedFood.text = foodChoices[randomIndex]
    }
}