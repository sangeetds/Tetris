package com.example.tetris

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1, exportSchema = false)

abstract class PlayerDataBase : RoomDatabase() {

    abstract fun playerDao() : PlayerDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile private var instance: PlayerDataBase? = null

        @Synchronized
        fun getDatabase(context: Context): PlayerDataBase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlayerDataBase::class.java, "player_name"
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return instance
        }
    }
}