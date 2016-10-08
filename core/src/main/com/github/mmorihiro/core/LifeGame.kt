package com.github.mmorihiro.core

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Table

class LifeGame : ApplicationAdapter() {
    val stage by lazy {
        Stage()
    }

    override fun create() {
        Gdx.input.inputProcessor = stage
        val table = Table()
        val skin = Skin(Gdx.files.internal("uiskin.json"))
        table.setFillParent(true)
        val button = Button(skin)
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