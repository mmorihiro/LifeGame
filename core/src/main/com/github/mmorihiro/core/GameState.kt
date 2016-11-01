package com.github.mmorihiro.core


internal class GameState {
    private var generation = 0
        get() = field
        set(value) {
            field = value
        }
    private var canIncrement = false

    private val setup = SetUpUILook(generation)

    private val newGeneration = MakeNewGeneration()

    init {
        addActionToButtons()
    }

    private fun addActionToButtons() {
        val startButton = setup.startButton
        val stopButton = setup.stopButton
        val resetButton = setup.resetButton
        startButton.addListener {
            if (startButton.isPressed) canIncrement = true
            startButton.isPressed
        }
        stopButton.addListener {
            if (stopButton.isPressed) canIncrement = false
            stopButton.isPressed
        }
        resetButton.addListener {
            if (resetButton.isPressed) {
                generation = 0
                setLabelText(generation)
                canIncrement = false
            }
            resetButton.isPressed
        }
    }

    private fun setLabelText(generation: Int) {
        setup.label.setText("generation: " + generation.toString())
    }

    fun incrementGeneration() {
        if (canIncrement) {
            setup.arrayActor.changeArray { newGeneration.get(it) }
            generation += 1
            setLabelText(generation)
        }
    }

    fun stage() = setup.stage
    
    fun dispose() {
        setup.dispose()
    }
}