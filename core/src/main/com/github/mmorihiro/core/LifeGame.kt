package com.github.mmorihiro.core

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.scenes.scene2d.ui.TextButton

class LifeGame : ApplicationAdapter() {
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
        table.add(button)
        stage.addActor(table)
    }

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }
    
    override fun dispose() {
        stage.dispose()
    }
}