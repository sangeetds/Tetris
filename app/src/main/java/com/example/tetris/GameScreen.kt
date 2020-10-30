package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.doOnLayout
import java.util.*

class GameScreen : AppCompatActivity() {
    lateinit var tetris: Tetris
    lateinit var tetrisView: TetrisView
    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        tetrisView = findViewById(R.id.tetrisView)
        val leftButton = findViewById<Button>(R.id.leftButton)
        val rightButton = findViewById<Button>(R.id.rightButton)

        tetrisView.doOnLayout {
            tetris = Tetris(screenWidth = it.width, screenHeight = it.height)
            startGame()

            leftButton.setOnClickListener {
                tetris.moveCurrentBlock(UserInput.Left)
            }

            rightButton.setOnClickListener {
                tetris.moveCurrentBlock(UserInput.Right)
            }
        }

        supportActionBar?.hide()
    }



    private fun startGame() {
        val runAsyncTask = object : TimerTask() {
            override fun run() {
                tetrisView.blocks = tetris.blocks

                tetrisView.invalidate()

                tetris.moveCurrentBlock(UserInput.Down)

                runOnUiThread {
                    val points: TextView = findViewById(R.id.currentPoints)
                    points.text = tetris.points.toString()
                }

                if (tetris.gameFinished) finishGame()
            }
        }

        timer.schedule(runAsyncTask, 0, 200)
    }

    private fun updateScore() {

    }

    private fun finishGame() {
        val gameOverScreen = Intent(this, GameOverActivity::class.java)
        gameOverScreen.putExtra("Score", tetris.points.toString())
        startActivity(gameOverScreen)

        finish()
    }

    override fun finish() {
        super.finish()
        timer.cancel()
    }
}