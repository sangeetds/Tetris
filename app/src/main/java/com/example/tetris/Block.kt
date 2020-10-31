package com.example.tetris

import android.graphics.RectF

data class Block(
    var row: Int,
    var col: Int,
    val rect: RectF,
    var active: Boolean,
)