package com.example.tetris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {

    @Query("SELECT * FROM tetris ORDER BY score DESC")
    fun getAllPlayer(): List<Player>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(player: Player)
}