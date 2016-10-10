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
    private val buttonTable = Table()
    private val skin = Skin(Gdx.files.internal("uiskin.json"))
    private val startButton = TextButton("start", skin)
    private val stopButton = TextButton("stop", skin)
    private val label = Label(generation.toString(), skin)

    init {
        Gdx.input.inputProcessor = stage
        table.setFillParent(true)
        
        addActionToButtons()
        setButtonPosition()

        buttonTable.add(startButton)
        buttonTable.add(stopButton)
        table.addActor(label)
        table.addActor(buttonTable)
        
        buttonTable.debug = true
        table.debug = true
        stage.addActor(table)
    }

    private fun setButtonPosition() {
        val centerX = Gdx.graphics.width / 2f
        val centerY = Gdx.graphics.height / 2f

        label.setPosition(centerX, centerY + startButton.height)
        buttonTable.setPosition(centerX, centerY)
    }

    private fun addActionToButtons() {
        startButton.addListener {
            if (startButton.isPressed) canIncrement = true
            startButton.isPressed
        }
        stopButton.addListener {
            if (stopButton.isPressed) canIncrement = false
            stopButton.isPressed
        }
    }

    fun incrementGeneration() {
        if (canIncrement) {
            generation += 1
            label.setText(generation.toString())
        }
    }
}