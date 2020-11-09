package com.example.tetris

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tetris")
data class Player(
    @PrimaryKey @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "score") val score: Int
)
