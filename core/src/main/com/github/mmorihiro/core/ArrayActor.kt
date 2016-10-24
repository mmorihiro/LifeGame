package com.github.mmorihiro.core

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Actor


class ArrayActor : Actor() {
    private val arraySize = 20
    private var array = Array(arraySize) { BooleanArray(arraySize) { false } }
    private val renderer = ShapeRenderer()
    private val size = 10f

    override fun draw(batch: Batch?, parentAlpha: Float) {
        batch!!.end()
        renderer.projectionMatrix = batch.projectionMatrix
        renderer.transformMatrix = batch.transformMatrix
        renderer.translate(x, y, 0f)
        renderer.begin(ShapeRenderer.ShapeType.Line)
        drawArray()
        renderer.end()
        batch.begin()
    }

    private fun drawArray() {
        val width = array[0].size * size
        val height = array.size * size
        for (i in 0..arraySize) {
            renderer.line(0f, size * i, width, size * i)
            renderer.line(size * i, 0f, size * i, height)
        }
    }
}