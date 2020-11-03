package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_game_over.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class GameOverActivity : AppCompatActivity() {

    private lateinit var playerDao: PlayerDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        playerDao = PlayerDataBase.getDatabase(this)!!.playerDao()

        val score = intent.getStringExtra("Score")!!
        val player = intent.getStringExtra("Player")!!
        val topPlayer = playerDao.getAllPlayer().firstOrNull()

        insert(Player(name = player, score = score.toInt()))

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

    private fun insert(player: Player) = GlobalScope.launch {
        playerDao.insert(player)
    }
}