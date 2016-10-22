package com.github.mmorihiro.core

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

class LifeGame : ApplicationAdapter() {
    private val state by lazy {
        GameState()
    }
    private val stage by lazy {
        state.stage()
    }

    override fun render() {
        state.incrementGeneration()
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(Gdx.graphics.deltaTime)
        stage.draw()
    }

    override fun dispose() {
        state.dispose()
    }
}