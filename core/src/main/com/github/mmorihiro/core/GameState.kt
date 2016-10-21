package com.github.mmorihiro.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton


class GameState {
    private var generation = 0
        get() = field
        set(value) {
            field = value
        }
    private var canIncrement = false
    
    val stage = Stage()
    private val table = Table()
    private val skin = Skin(Gdx.files.internal("uiskin.json"))
    private val startButton = TextButton("start", skin)
    private val label = Label(generation.toString(), skin)

    init {
        Gdx.input.inputProcessor = stage
        table.setFillParent(true)
        startButton.addListener {
            if (startButton.isPressed) canIncrement = true
            startButton.isPressed
        }
        val centerX = Gdx.graphics.width / 2f
        val centerY = Gdx.graphics.height / 2f

        label.setPosition(centerX, centerY + startButton.height)
        startButton.setPosition(centerX, centerY)

        table.addActor(label)
        table.addActor(startButton)
        table.debug = true
        stage.addActor(table)
    }

    fun incrementGeneration() {
        if (canIncrement) {
            generation += 1
            label.setText(generation.toString())
        }
    }

    fun dispose() {
        stage.dispose()
        skin.dispose()
    }
}