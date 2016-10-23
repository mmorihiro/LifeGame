package com.github.mmorihiro.core

import io.kotlintest.specs.WordSpec


internal class TestMakeNewGeneration : WordSpec() {
    init {
        "MakeNewGeneration.get" should {
            "return the same size array" {
                val sut = MakeNewGeneration()
                val expect = 10
                val array = Array(expect) { BooleanArray(expect) { false } }
                sut.get(array).size shouldBe expect
            }
        }
    }
}
