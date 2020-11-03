package com.example.tetris

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player_name ORDER BY score DESC")
    fun getAllPlayer(): List<Player>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(player: Player)
}