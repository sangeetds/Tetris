package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class Scores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)

        val topPlayers = BlockProvider.playerData.sortedByDescending { it.score }

        val firstPosition = findViewById<TextView>(R.id.positon_one)
        val secondPosition = findViewById<TextView>(R.id.position_two)
        val thirdPosition = findViewById<TextView>(R.id.position_three)

        firstPosition.text = if (topPlayers.isEmpty()) "" else "1. ${topPlayers[0].name} ${topPlayers[0].score}"
        secondPosition.text = if (topPlayers.size < 2) "" else "2. ${topPlayers[1].name} ${topPlayers[1].score}"
        thirdPosition.text = if (topPlayers.size < 3) "" else "3. ${topPlayers[2].name} ${topPlayers[2].score}"
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