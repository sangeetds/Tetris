package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val highScoreButton = findViewById<Button>(R.id.highScoreButton)
        val settingButton = findViewById<Button>(R.id.settingButton)
        val playerName = findViewById<EditText>(R.id.playerName)

        playerName.text.clear()

        startButton.setOnClickListener {
            if (playerName.text.isEmpty() || playerName.text.isBlank()) {
                Toast.makeText(this, "Enter your name please", Toast.LENGTH_SHORT).show()
            }
            else {
                val mainGame = Intent(this, GameScreen::class.java)
                val text = playerName.text.toString()
                mainGame.putExtra("Player", text)
                startActivity(mainGame)
            }
        }

        highScoreButton.setOnClickListener {
            val scoreScreen = Intent(this, Scores::class.java)
            startActivity(scoreScreen)
        }

        settingButton.setOnClickListener {
            val settingScreen = Intent(this, SettingsActivity::class.java)
            startActivity(settingScreen)
        }
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