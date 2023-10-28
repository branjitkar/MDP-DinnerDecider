package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dinnerdecider.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val foodChoices = arrayListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun addFood(view:View) {
        val newFood = binding.etNewFood.text
        if(!newFood.isNullOrBlank()) {
            if(!foodChoices.contains(newFood.toString()))
                foodChoices.add(newFood.toString())
            binding.etNewFood.text = null
        }
    }

    fun decideRandomFood(view: View) {
        val randomIndex = Random.nextInt(foodChoices.size)
        binding.tvDecidedFood.text = foodChoices[randomIndex]
    }
}