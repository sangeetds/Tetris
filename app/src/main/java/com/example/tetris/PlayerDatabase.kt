package com.example.tetris

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class PlayerDatabase : RoomDatabase() {

    abstract fun playerDao() : PlayerDao

    companion object {
        @Volatile private var instance: PlayerDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): PlayerDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlayerDatabase::class.java, "player_name"
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return instance
        }
    }
}