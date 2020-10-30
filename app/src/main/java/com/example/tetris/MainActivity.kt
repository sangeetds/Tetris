package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val highScoreButton = findViewById<Button>(R.id.highScoreButton)
        val settingButton = findViewById<Button>(R.id.settingButton)

        startButton.setOnClickListener {
            val mainGame = Intent(this, GameScreen::class.java)
            startActivity(mainGame)

//            TODO("Pass Name As Well")
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