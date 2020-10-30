package com.example.tetris

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.Toast

class TetrisView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    var blocks: List<List<Block>> = emptyList()
    private val paint = Paint()

    // This function will run everytime invalidate() is called.
    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)

        blocks.forEach { lst ->
            lst.filter { it.active }.forEach { block ->
                paint.color = Color.WHITE
                canvas.drawRect(block.rect, paint)
            }
        }
    }
}