package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_game_over.*


class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val score = intent.getStringExtra("Score")

        if (score!!.toInt() > topPlayer.score) {
            newHighScore.visibility = View.VISIBLE
        }

        val points = findViewById<TextView>(R.id.points)
        points.text = score

        retryButton.setOnClickListener {
            val scoreScreen = Intent(this, GameScreen::class.java)
            startActivity(scoreScreen)
            finish()
        }

        shareButton.setOnClickListener {
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