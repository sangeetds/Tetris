package com.example.tetris

import androidx.lifecycle.LiveData

class PlayerRepository(private val playerDao: PlayerDao) {
    val allPlayers: List<Player> = playerDao.getAllPlayer()

    suspend fun insert(player: Player) {
        playerDao.insert(player)
    }
}