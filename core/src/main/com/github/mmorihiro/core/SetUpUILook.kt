package com.github.mmorihiro.core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton


internal class SetUpUILook(generation: Int) {
    val stage = Stage()
    private val table = Table()
    private val buttonTable = Table()
    private val skin = Skin(Gdx.files.internal("uiskin.json"))
    val stopButton = TextButton("stop", skin)
    val resetButton = TextButton("reset", skin)
    val label = Label("generation: " + generation.toString(), skin)
    val startButton = TextButton("start", skin)
    val arrayActor = ArrayActor()

    init {
        Gdx.input.inputProcessor = stage
        table.setFillParent(true)

        setPosition()

        buttonTable.add(startButton)
        buttonTable.add(stopButton)
        buttonTable.add(resetButton)
        table.addActor(label)
        table.addActor(buttonTable)

        buttonTable.debug = true
        table.debug = true

        stage.addActor(arrayActor)
        stage.addActor(table)
    }

    private fun setPosition() {
        val centerX = Gdx.graphics.width / 2f

        buttonTable.setPosition(centerX - 40, 20f)
        label.setPosition(centerX - 100, buttonTable.y + startButton.height)
        arrayActor.setPosition(label.x, label.y + 50)
    }

    fun dispose() {
        stage.dispose()
        skin.dispose()
    }

    fun dispose() {
        skin.dispose()
        stage.dispose()
    }
}