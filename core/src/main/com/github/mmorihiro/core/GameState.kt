package com.github.mmorihiro.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton


class GameState {
    var generation = 0
    get() = field
    set(value) {
        field = value
    }
    
    val stage = Stage()

    private val table = Table()
    private val skin = Skin(Gdx.files.internal("uiskin.json"))
    private val button = TextButton("not pushed", skin)
    private val label = Label(generation.toString(), skin)

    init {
        Gdx.input.inputProcessor = stage
        table.setFillParent(true)
        button.addListener {
            if (button.isPressed) button.setText("pushed")
            button.isPressed
        }
        val centerX = Gdx.graphics.width / 2f
        val centerY = Gdx.graphics.height / 2f

        label.setPosition(centerX, centerY + button.height)
        button.setPosition(centerX, centerY)

        table.addActor(label)
        table.addActor(button)
        table.debug = true
        stage.addActor(table)
    }
    
    fun incrementGeneration() {
        generation += 1
        label.setText(generation.toString())
    }

    fun dispose() {
        stage.dispose()
        skin.dispose()
    }
}