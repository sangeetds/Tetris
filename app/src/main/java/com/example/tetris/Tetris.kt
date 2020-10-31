package com.example.tetris

import android.graphics.*
import kotlin.math.roundToInt


class Tetris(val screenWidth: Int, val screenHeight: Int) {
    var gameFinished = false
    var points = 0
    private val dyChangeValue = (screenHeight / 20f).roundToInt().toFloat()
    private val dxChangeValue = (screenWidth / 20f).roundToInt().toFloat()
    val blocks: List<List<Block>>
    private var currentBlockCoordinates: List<Pair<Int, Int>>

    init {
        var dy = -dyChangeValue
        var row = -1

        blocks = List(20) {
            var dx = -dxChangeValue
            dy += dyChangeValue
            var col = -1
            row++

            List(20) {
                dx += dxChangeValue
                col++
                Block(row = row , col = col, rect = RectF(dx, dy, dx + dxChangeValue, dy + dyChangeValue), active = false)
            }
        }

        currentBlockCoordinates = BlockProvider.getNewBlock()
        currentBlockCoordinates.forEach { (r, c) -> blocks[r][c].active = true }
    }

    fun moveCurrentBlock(direction: UserInput) {
        val newCoordinates = currentBlockCoordinates.map { (r, c) -> Pair(r + if (direction == UserInput.Down) 1 else 0, c + if (direction == UserInput.Left) -1 else if (direction == UserInput.Right) 1 else 0) }
        val collision = newCoordinates.shareSameSpace()

        if (collision) {
            currentBlockCoordinates.forEach { (r, c) -> blocks[r][c].active = false }
            newCoordinates.forEach { (r, c) -> blocks[r][c].active = true }
            currentBlockCoordinates = newCoordinates
        }
        else if (direction == UserInput.Down) {
            val anotherBlock = BlockProvider.getNewBlock()

            if (!anotherBlock.shareSameSpace()) {
                gameFinished = true
                return
            }

            currentBlockCoordinates = anotherBlock
            currentBlockCoordinates.forEach { (r, c) -> blocks[r][c].active = true }
        }

        clearLine()
    }

    private fun clearLine() {
        blocks.forEachIndexed { rowIndex, row ->
            if (row.all { block -> block.active }) {
                row.forEach { it.active = false }
                points += 100

                for (tempRow in rowIndex - 1 downTo 0) {
                    blocks[tempRow].forEachIndexed { blockIndex, block ->
                        if (block.active) {
                            block.active = false
                            blocks[tempRow + 1][blockIndex].active = true
                        }
                    }
                }
            }
        }
    }

    private fun List<Pair<Int, Int>>.shareSameSpace(): Boolean {
        if (!this.all { it.inSpace() }) {
            return false
        }

        currentBlockCoordinates.forEach { (r, c) -> blocks[r][c].active = false }

        val noCollision = this.none { (r, c) -> blocks[r][c].active }

        currentBlockCoordinates.forEach { (r, c) -> blocks[r][c].active = true }

        return noCollision
    }

    private fun Pair<Int, Int>.inSpace() = this.first in blocks.indices && this.second in blocks[this.first].indices

    fun rotateCurrentBlock() {
        
    }
}



