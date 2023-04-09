package com.example.threeinarow.gameField

import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.gameFieldObjects.jewel.SimpleJewel
import com.example.threeinarow.gameFieldObjects.jewel.special.Bomb
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MatrixSkannerTest {

    val matrix = arrayOf(
        arrayOf<Jewel?>(SimpleJewel("B"), SimpleJewel("B"), SimpleJewel("B")),
        arrayOf<Jewel?>(SimpleJewel("B"), SimpleJewel("R"), SimpleJewel("W")),
        arrayOf<Jewel?>(SimpleJewel("B"), SimpleJewel("R"), SimpleJewel("R")) )

        val scann = MatrixSkanner(this.matrix)


    @Test
    fun skanRows() {
        val expected = arrayOf(
            arrayOf<Jewel?>(Bomb("B"), null, null),
            arrayOf<Jewel?>(null, SimpleJewel("R"), SimpleJewel("W")),
            arrayOf<Jewel?>(null, SimpleJewel("R"), SimpleJewel("R")) )
        scann.skanRows()
        assertArrayEquals(expected, matrix)
    }
}

