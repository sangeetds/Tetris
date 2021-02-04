package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class Scores : AppCompatActivity() {

//    private lateinit var playerDao: PlayerDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)
//        playerDao = PlayerDataBase.getDatabase(applicationContext)!!.playerDao()

//        GlobalScope.launch {
        val playerDao = PlayerDatabase.getDatabase(applicationContext)!!.playerDao()
        val playerRepository = PlayerRepository(playerDao = playerDao)
//        }

        val topPlayers = playerRepository.allPlayers

        val firstPosition = findViewById<TextView>(R.id.position_one)
        val secondPosition = findViewById<TextView>(R.id.position_two)
        val thirdPosition = findViewById<TextView>(R.id.position_three)

        firstPosition.text = if (topPlayers.isEmpty()) "" else "1. ${topPlayers[0].name} ${topPlayers[0].score}"
        secondPosition.text = if (topPlayers.size < 2) "" else "2. ${topPlayers[1].name} ${topPlayers[1].score}"
        thirdPosition.text = if (topPlayers.size < 3) "" else "3. ${topPlayers[2].name} ${topPlayers[2].score}"
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