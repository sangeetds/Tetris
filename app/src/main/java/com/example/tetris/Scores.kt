package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class Scores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        val topPlayers = playerData.sortedByDescending { it.score }

        val firstPosition = findViewById<TextView>(R.id.first_position)
        val secondPosition = findViewById<TextView>(R.id.secondPosition)
        val thirdPosition = findViewById<TextView>(R.id.thirdPosition)

        val topScore = findViewById<TextView>(R.id.top_score)
        val secondTopScore = findViewById<TextView>(R.id.second_score)
        val thirdTopScore = findViewById<TextView>(R.id.third_score)

        firstPosition.text = if (topPlayers.isEmpty()) "" else topPlayers[0].name
        secondPosition.text = if (topPlayers.size < 2) "" else topPlayers[1].name
        thirdPosition.text = if (topPlayers.size < 3) "" else topPlayers[2].name

        topScore.text = if (topPlayers.isEmpty()) "" else topPlayers[0].score.toString()
        secondTopScore.text = if (topPlayers.size < 2) "" else topPlayers[1].score.toString()
        thirdTopScore.text = if (topPlayers.size < 3) "" else topPlayers[2].score.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.game_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val aboutIntent = Intent(this, About::class.java)
        startActivity(aboutIntent)

        return true
    }

}