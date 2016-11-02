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

            ("""
            |make new generation
            |when there are three living cell adjacent to one dead cell
            """.trimMargin()) {
                val array = arrayOf(
                        booleanArrayOf(true, true),
                        booleanArrayOf(true, false))

                sut.get(array)[1][1] shouldBe true
            }

            ("""
            |continue to make them alive
            |if there are two or three living cells
            |adjacent to the living cell
            """.trimMargin()) {
                val array = arrayOf(
                        booleanArrayOf(false, false, false, false),
                        booleanArrayOf(false, true, true, false),
                        booleanArrayOf(false, true, true, false),
                        booleanArrayOf(false, false, false, false))
                val actual = sut.get(array)

                val expectAlive = table(
                        headers("x", "y"),
                        row(1, 1),
                        row(1, 2),
                        row(2, 1),
                        row(2, 2))
                forAll(expectAlive) { x, y -> actual[x][y] shouldBe true }
            }

            "kill the living cell adjacent to less than one living cell" {
                val array = arrayOf(
                        booleanArrayOf(false, false, false),
                        booleanArrayOf(false, true, true),
                        booleanArrayOf(false, false, false))

                val actual = sut.get(array)

                actual[1][1] shouldBe false
                actual[1][2] shouldBe false
            }

            "kill the living cell adjacent to more than four living cells" {
                val array = arrayOf(
                        booleanArrayOf(true, true, true),
                        booleanArrayOf(true, true, false),
                        booleanArrayOf(false, false, false))

                val actual = sut.get(array)

                actual[0][1] shouldBe false
                actual[1][1] shouldBe false
            }
        }

        "BooleanArray.copyOf" should {
            "return shallow copy" {
                val array = arrayOf(
                        booleanArrayOf(true, true, true),
                        booleanArrayOf(true, true, false),
                        booleanArrayOf(false, false, false))
                val copy = array.copyOf()
                copy[1][1] = false
                array[1][1] shouldBe false
            }
        }

    }
}
