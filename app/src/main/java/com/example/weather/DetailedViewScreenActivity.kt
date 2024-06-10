package com.example.weather

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewScreenActivity : AppCompatActivity() {

    private lateinit var detailsTextView: TextView
    private lateinit var avgTempTextView: TextView
    private lateinit var backButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        detailsTextView = findViewById(R.id.detailsTextView)
        avgTempTextView = findViewById(R.id.avgTempTextView)
        backButton = findViewById(R.id.backButton)

        val dates = intent.getStringArrayListExtra("dates") ?: arrayListOf()
        val minTemps = intent.getIntegerArrayListExtra("minTemps") ?: arrayListOf()
        val maxTemps = intent.getIntegerArrayListExtra("maxTemps") ?: arrayListOf()
        val weatherConditions = intent.getStringArrayListExtra("weatherConditions") ?: arrayListOf()
        val avgTemp = intent.getIntExtra("avgTemp", 0)

        val details = StringBuilder()
        for (i in dates.indices) {
            details.append("${dates[i]}: Min Temp - ${minTemps[i]}°C, Max Temp - ${maxTemps[i]}°C, Weather - ${weatherConditions[i]}\n")
        }

        detailsTextView.text = details.toString()
        avgTempTextView.text = "Average Temperature: $avgTemp°C"

        backButton.setOnClickListener {
            finish()
        }
    }
}