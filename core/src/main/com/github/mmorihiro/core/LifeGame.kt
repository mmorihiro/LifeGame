package com.github.mmorihiro.core

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton

class LifeGame : ApplicationAdapter() {
    val state = GameState()
    val stage by lazy {
        Stage()
    }

    override fun create() {
        Gdx.input.inputProcessor = stage
        val table = Table()
        val skin = Skin(Gdx.files.internal("uiskin.json"))
        table.setFillParent(true)
        val button = TextButton("not pushed", skin)
        button.addListener {
            if (button.isPressed) button.setText("pushed")
            button.isPressed
        }
        
        val generation = Label(state.generation.toString(), skin)
        val centerX = Gdx.graphics.width / 2f
        val centerY = Gdx.graphics.height / 2f
        generation.setPosition(centerX, centerY + button.height)
        button.setPosition(centerX, centerY)
        table.addActor(generation)
        table.addActor(button)
        table.debug = true
        stage.addActor(table)
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun dispose() {
        stage.dispose()
    }
}