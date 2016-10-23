package com.github.mmorihiro.core

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Actor


internal class ArrayActor : Actor() {
    private val arraySize = 20
    private val array = Array(arraySize) { BooleanArray(arraySize) { false } }
    private val renderer = ShapeRenderer()
    private val size = 10f

    init {
        array[0][0] = true
        array[5][5] = true
        array[10][10] = true
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        batch!!.end()
        renderer.projectionMatrix = batch.projectionMatrix
        renderer.transformMatrix = batch.transformMatrix
        renderer.translate(x, y, 0f)
        renderer.begin(ShapeRenderer.ShapeType.Filled)
        renderer.setAutoShapeType(true)
        drawArray()
        renderer.end()
        batch.begin()
    }

    private fun drawArray() {
        val width = array[0].size * size
        val height = array.size * size
        renderer.color = Color.GREEN
        for (i in array.indices) {
            for (j in array[0].indices) {
                if (array[j][i]) {
                    renderer.rect(size * j, size * i, size, size)
                }
            }
        }
        renderer.set(ShapeRenderer.ShapeType.Line)
        renderer.color = Color.WHITE
        for (i in 0..arraySize) {
            renderer.line(0f, size * i, width, size * i)
            renderer.line(size * i, 0f, size * i, height)
        }
    }
}