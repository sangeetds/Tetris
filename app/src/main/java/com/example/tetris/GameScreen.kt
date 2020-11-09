package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.widget.Button
import android.widget.TextView
import androidx.core.view.doOnLayout
import java.util.*

class GameScreen : AppCompatActivity() {
    lateinit var tetris: Tetris
    lateinit var tetrisView: TetrisView
    private var timer = Timer()
    private lateinit var instance: GameScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)
        instance = this

        tetrisView = findViewById(R.id.tetrisView)
        val leftButton = findViewById<Button>(R.id.leftButton)
        val rightButton = findViewById<Button>(R.id.rightButton)
        val rotateButton = findViewById<Button>(R.id.rotateButton)

        tetrisView.doOnLayout {
            tetris = Tetris(screenWidth = it.width, screenHeight = it.height)
            startGame()

            leftButton.setOnClickListener {
                tetris.moveCurrentBlock(UserInput.Left)
                leftButton.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
            }

            rightButton.setOnClickListener {
                tetris.moveCurrentBlock(UserInput.Right)
            }

            rotateButton.setOnClickListener {
                tetris.rotateCurrentBlock()
            }
        }

        supportActionBar?.hide()
    }

    fun startGame() {
        val runAsyncTask = object : TimerTask() {
            override fun run() {
                tetrisView.blocks = tetris.blocks

                tetris.moveCurrentBlock(UserInput.Down)

                runOnUiThread {
                    val points: TextView = findViewById(R.id.currentPoints)
                    points.text = tetris.points.toString()
                }

                if (tetris.gameFinished) finishGame()
                else tetrisView.invalidate()
            }
        }

        timer.schedule(runAsyncTask, 0, 200)
    }

    private fun finishGame() {
        val gameOverScreen = Intent(this, GameOverActivity::class.java)
        gameOverScreen.putExtra("Score", tetris.points.toString())
        gameOverScreen.putExtra("Player", intent.getStringExtra("Player"))
        startActivity(gameOverScreen)

        finish()
    }

    override fun finish() {
        super.finish()
        timer.cancel()
    }

    override fun onBackPressed() {
        timer.cancel()
        timer = Timer()
        val quitDialog = GameDialogMessage(this, instance)
        quitDialog.show()
    }
}