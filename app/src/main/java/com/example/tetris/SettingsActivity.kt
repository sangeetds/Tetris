package com.example.tetris

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        val musicSwitch = findViewById<Button>(R.id.musicButton)

//        musicSwitch.setOnClickListener {
//
//        }
    }


}