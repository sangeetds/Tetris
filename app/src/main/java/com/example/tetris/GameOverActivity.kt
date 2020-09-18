package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Button
//import android.widget.TextView

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

//        val score = intent.getStringExtra(Intent.EXTRA_TEXT)
//
//        if (score!!.toInt() > topPlayer.score) {
//            val scoreView = findViewById<TextView>(R.id.new_high_score)
//            scoreView.visibility = View.GONE
//        }

        val retryButton = findViewById<Button>(R.id.retry_button)
        val shareScoreButton = findViewById<Button>(R.id.share_button)

        retryButton.setOnClickListener {
            val scoreScreen = Intent(this, Scores::class.java)
            startActivity(scoreScreen)
            finish()
        }

        shareScoreButton.setOnClickListener {
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }

    private val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "Top Score!")
        type = "text/plain"
    }
}