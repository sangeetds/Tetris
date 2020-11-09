package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_game_over.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        val playerRepo = PlayerRepository(PlayerDatabase.getDatabase(this)!!.playerDao())
        val players = playerRepo.allPlayers

        val score = intent.getStringExtra("Score")!!
        val playerName = intent.getStringExtra("Player")!!
        val topPlayer = players.firstOrNull()

        insert(Player(name = playerName, score = score.toInt()), playerRepo)

        if (topPlayer != null && score.toInt() > topPlayer.score) {
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

    private fun insert(player: Player, playersRepo: PlayerRepository) = GlobalScope.launch {
        playersRepo.insert(player)
    }
}