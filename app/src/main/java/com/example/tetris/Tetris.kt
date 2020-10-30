package com.example.tetris

import android.graphics.*
import kotlin.math.roundToInt


class Tetris(val screenWidth: Int, val screenHeight: Int) {
    var gameFinished = false
    var points = 0
    private val dyChangeValue = (screenHeight / 20f).roundToInt().toFloat()
    private val dxChangeValue = (screenWidth / 20f).roundToInt().toFloat()
    val blocks: List<List<Block>>

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
                Block(row = row , col = col, RectF(dx, dy, dx + dxChangeValue, dy + dyChangeValue), active = false)
            }
        }
    }

    fun update() {

    }

    private fun clearLine(
        dxChangeValue: Float,
        dyChangeValue: Float,
        blocks: MutableList<Block>,
        screenWidth: Int,
        screenHeight: Int
    ) {


        points += 100
    }

    fun sendInput(input: UserInput) {
        when (input) {
            UserInput.Left -> {

            }
            UserInput.Right -> {

            }
        }
    }

    private fun MutableList<Block>.shareSameSpace(activeBlock: Block, down: UserInput): Boolean {

        this.forEach { currBlock ->
            if (
                currBlock != activeBlock && !activeBlock.intersect(currBlock, down)
            )
                return true
        }

        return false
    }

    private fun Block.intersect(otherBlock: Block, input: UserInput): Boolean {
        return false
    }

    private fun Path.inSpace(): Boolean {
        return false
    }
}



