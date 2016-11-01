package com.github.mmorihiro.core


internal class MakeNewGeneration {
    fun get(array: Array<BooleanArray>): Array<BooleanArray> {
        for (i in array.indices) {
            for (j in array[0].indices) {
                when (Pair(array[i][j], countSurroundings(array, i, j))) {
                    Pair(false, 3) -> array[i][j] = true
                }
            }
        }
        return array
    }

    private fun countSurroundings(array: Array<BooleanArray>,
                                  i: Int, j: Int): Int {
        var surroundings = 0
        for (x in i - 1..i + 1) {
            for (y in j - 1..j + 1) {
                when {
                    !(x == i && y == j) &&
                            array[0].indices.contains(x)
                            && array.indices.contains(y)
                            && array[y][x] -> surroundings += 1
                }
            }
        }
        return surroundings
    }
}