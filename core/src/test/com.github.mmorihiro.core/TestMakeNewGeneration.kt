package com.github.mmorihiro.core

import io.kotlintest.specs.WordSpec


class TestMakeNewGeneration : WordSpec() {
    init {
        val sut = MakeNewGeneration()
        "MakeNewGeneration.get" should {
            "return the same size array" {
                val expect = 10
                val array = Array(expect) { BooleanArray(expect) { false } }
                sut.get(array).size shouldBe expect
            }

            """make new generation
            when there are three living cell adjacent to one dead cell""" {
                val array = arrayOf(
                        booleanArrayOf(true, true),
                        booleanArrayOf(true, false))
                sut.get(array)[1][1] shouldBe true
            }
        }

    }
}
