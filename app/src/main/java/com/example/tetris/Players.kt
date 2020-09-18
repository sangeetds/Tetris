package com.example.tetris

data class Players(val name: String, val score: Int)

val playerData = mutableListOf(
    Players(name = "Sangeet", score = 54005),
    Players(name = "Devian", score = 400125),
    Players(name = "Sonato", score = 6005)
)

val topPlayer = playerData.maxByOrNull { it.score }!!