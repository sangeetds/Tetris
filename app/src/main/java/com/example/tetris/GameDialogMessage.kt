package com.example.tetris

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import java.util.*

class GameDialogMessage(activity: Activity, private val game: GameScreen) : Dialog(activity) {

    val context = activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.game_quit_dialog)

        val gameRestartButton = findViewById<Button>(R.id.restart_button)
        val gameResumeButton = findViewById<Button>(R.id.resume_button)
        val gameQuitButton = findViewById<Button>(R.id.quit_button)

        gameQuitButton.setOnClickListener {
            context.finish()
        }

        gameRestartButton.setOnClickListener {
            context.recreate()
        }

        gameResumeButton.setOnClickListener {
            game.startGame()
            dismiss()
        }
    }
}