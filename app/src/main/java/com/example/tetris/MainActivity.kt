package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
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
        }

        scoreButton.setOnClickListener {
            val mainGame = Intent(this, GameScreen::class.java)
            startActivity(mainGame)
        }

        startGameButton.setOnClickListener {
            val mainGame = Intent(this, GameScreen::class.java)
            startActivity(mainGame)
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