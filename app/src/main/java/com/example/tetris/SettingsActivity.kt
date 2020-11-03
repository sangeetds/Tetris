package com.example.tetris

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        val musicSwitch = findViewById<ToggleButton>(R.id.musicButton)

        musicSwitch.setOnCheckedChangeListener { buttonView, isChecked ->

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