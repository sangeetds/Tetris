package com.example.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Scores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        val topPlayers= playerData.sortedByDescending { it.score }

        val firstPosition = findViewById<TextView>(R.id.firstPosition)
        val secondPosition = findViewById<TextView>(R.id.secondPosition)
        val thirdPosition = findViewById<TextView>(R.id.thirdPosition)

        firstPosition.text = "1. ${topPlayers[0].name}"
    }

}