package com.example.tetris

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import kotlin.math.absoluteValue

class Tetris(context: Context, contentLayout: RelativeLayout) : View(context) {

    val painter = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 10f
        style = Paint.Style.FILL
    }

    val screenHeight = contentLayout.height
    val screenWidth = contentLayout.width

    val block = Rect(50,50,200,200)


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        painter.color = Color.WHITE
        canvas?.drawRect(block, painter)
    }

    fun render() {
        if ((block.bottom - screenHeight).absoluteValue > 50) {
            block.top += 5
            block.bottom += 5
        }

        invalidate()
    }

    fun loop() {
        render()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }
}