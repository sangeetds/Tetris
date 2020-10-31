package com.example.tetris

object BlockProvider {
    val playerData = mutableListOf<Player>(Player("null", 9))
    val topPlayer: Player? get() = playerData.maxByOrNull { it.score }

    fun getNewBlock() =
        when ((0..6).random()) {
            0 -> {
                listOf(Pair(0, 9), Pair(0, 10), Pair(1, 9), Pair(2, 9))
            }
            1 -> {
                listOf(Pair(0, 9), Pair(0, 10), Pair(1, 9), Pair(1, 10))
            }
            2 -> {
                listOf(Pair(0, 9), Pair(0, 10), Pair(1, 10), Pair(2, 10))
            }
            3 -> {
                listOf(Pair(1, 9), Pair(0, 10), Pair(1, 10), Pair(1, 11))
            }
            4 -> {
                listOf(Pair(0, 10), Pair(1, 10), Pair(1, 9), Pair(2, 9))
            }
            5 -> {
                listOf(Pair(0, 9), Pair(1, 9), Pair(1, 10), Pair(2, 10))
            }
            else -> {
                listOf(Pair(0, 9), Pair(0, 10), Pair(0, 11), Pair(0, 12))
            }
        }
}
