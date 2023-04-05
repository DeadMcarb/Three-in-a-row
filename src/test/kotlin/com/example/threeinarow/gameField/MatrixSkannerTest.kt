package com.example.threeinarow.gameField

import com.example.threeinarow.gameFieldObjects.SimpleJewel
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MatrixSkannerTest {

        val matrix = arrayOf(
            arrayOf(SimpleJewel("B"), SimpleJewel("R"), SimpleJewel("R")),
            arrayOf(SimpleJewel("B"), SimpleJewel("R"), SimpleJewel("W")),
            arrayOf(SimpleJewel("B"), SimpleJewel("B"), SimpleJewel("B")) )

        val scann = MatrixSkanner(this.matrix)


    @Test
    fun skanRows() {
        val expected = hashSetOf<Pair<Int, Int>>()
        expected.add(Pair(2,0))
        expected.add(Pair(2,1))
        expected.add(Pair(2,2))
        scann.skanRows()
        assertEquals(expected, scann.ListOfObjectsToRemove)
    }
}