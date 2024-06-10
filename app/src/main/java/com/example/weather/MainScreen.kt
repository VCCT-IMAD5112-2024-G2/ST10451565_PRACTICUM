package com.example.weather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainScreen : AppCompatActivity() {


    private lateinit var dateEditText: EditText
    private lateinit var minTempEditText: EditText
    private lateinit var maxTempEditText: EditText
    private lateinit var weatherConditionEditText: EditText

    private val dates = ArrayList<String>()
    private val minTemps = ArrayList<Int>()
    private val maxTemps = ArrayList<Int>()
    private val weatherConditions = ArrayList<String>()
    private var avgTemp: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        dateEditText = findViewById(R.id.dateEditText)
        minTempEditText = findViewById(R.id.minTempEditText)
        maxTempEditText = findViewById(R.id.maxTempEditText)
        weatherConditionEditText = findViewById(R.id.weatherConditionEditText)

        val addButton: Button = findViewById(R.id.addButton)
        val clearButton: Button = findViewById(R.id.clearButton)
        val detailedViewButton: Button = findViewById(R.id.detailedViewButton)
        val exitButton2: Button = findViewById(R.id.exitoutButton)

        exitButton2.setOnClickListener {
            finish()
        }

        addButton.setOnClickListener {
            addWeatherData()
        }

        clearButton.setOnClickListener {
            clearData()
        }

        detailedViewButton.setOnClickListener {
            val intent = Intent(this, DetailedViewScreenActivity::class.java)
            intent.putStringArrayListExtra("dates", dates)
            intent.putIntegerArrayListExtra("minTemps", minTemps)
            intent.putIntegerArrayListExtra("maxTemps", maxTemps)
            intent.putStringArrayListExtra("weatherConditions", weatherConditions)
            intent.putExtra("avgTemp", avgTemp)
            startActivity(intent)
        }
    }

    private fun addWeatherData() {
        val date = dateEditText.text.toString()
        val minTemp = minTempEditText.text.toString().toIntOrNull()
        val maxTemp = maxTempEditText.text.toString().toIntOrNull()
        val weatherCondition = weatherConditionEditText.text.toString()

        if (date.isNotEmpty() && minTemp != null && maxTemp != null && weatherCondition.isNotEmpty()) {
            dates.add(date)
            minTemps.add(minTemp)
            maxTemps.add(maxTemp)
            weatherConditions.add(weatherCondition)

            dateEditText.text.clear()
            minTempEditText.text.clear()
            maxTempEditText.text.clear()
            weatherConditionEditText.text.clear()

            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
            updateAverageTemperature()
        } else {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateAverageTemperature() {
        if (minTemps.isNotEmpty() && maxTemps.isNotEmpty()) {
            var totalTemp = 0
            val count = minTemps.size
            for (i in 0 until count) {
                totalTemp += (minTemps[i] + maxTemps[i]) / 2
            }
            avgTemp = totalTemp / count
        } else {
            avgTemp = 0
        }
    }

    private fun clearData() {
        dates.clear()
        minTemps.clear()
        maxTemps.clear()
        weatherConditions.clear()

        dateEditText.text.clear()
        minTempEditText.text.clear()
        maxTempEditText.text.clear()
        weatherConditionEditText.text.clear()

        Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show()
    }
}





