package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startGameButton = findViewById<Button>(R.id.startButton)
        val scoreButton = findViewById<Button>(R.id.highScore)
        val settingsButton = findViewById<Button>(R.id.settings)

        startGameButton.setOnClickListener {
            val mainGame = Intent(this, GameScreen::class.java)
            startActivity(mainGame)
            Log.i(R.id.main.toString(), "A")
            Toast.makeText(this, "startGAme", Toast.LENGTH_SHORT).show()
        }

        scoreButton.setOnClickListener {
            val scoreScreen = Intent(this, Scores::class.java)
            startActivity(scoreScreen)
            Log.i(R.id.main.toString(), "B")
            Toast.makeText(this, "score", Toast.LENGTH_SHORT).show()
        }

        startGameButton.setOnClickListener {
            val settingScreen = Intent(this, SettingsActivity::class.java)
            startActivity(settingScreen)
            Log.i(R.id.main.toString(), "C")
            Toast.makeText(this, "start", Toast.LENGTH_SHORT).show()
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