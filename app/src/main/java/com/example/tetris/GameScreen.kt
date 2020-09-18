package com.example.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_screen.*
import java.util.*

class GameScreen : AppCompatActivity() {
    lateinit var tetris: Tetris
    val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        layoutMainScreenGame.post {
            tetris = Tetris(this, layoutMainScreenGame)

            layoutMainScreenGame.addView(tetris)

            layoutMainScreenGame.setOnClickListener {
                startGame()
            }
        }

        supportActionBar?.hide()
    }

    private fun startGame() {
        val runAsynchTask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    tetris.loop()
                }
            }
        }

        timer.schedule(runAsynchTask, 0, 20)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}