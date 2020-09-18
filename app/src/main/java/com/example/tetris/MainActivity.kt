package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            val mainGame = Intent(this, GameScreen::class.java)
            startActivity(mainGame)
            Log.i(R.id.main.toString(), "A")
        }

        highScoreButton.setOnClickListener {
            val scoreScreen = Intent(this, Scores::class.java)
            startActivity(scoreScreen)
            Log.i(R.id.main.toString(), "B")
        }

        settingButton.setOnClickListener {
            val settingScreen = Intent(this, SettingsActivity::class.java)
            startActivity(settingScreen)
            Log.i(R.id.main.toString(), "C")
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