package com.example.threeinarow.gameField

import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.gameFieldObjects.jewel.SimpleJewel
import com.example.threeinarow.gameFieldObjects.jewel.special.Bomb
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MatrixSkannerTest {

    val matrix = arrayOf(
        arrayOf<Jewel?>(SimpleJewel("B"), SimpleJewel("B"), SimpleJewel("B"), SimpleJewel("C")),
        arrayOf<Jewel?>(SimpleJewel("B"), SimpleJewel("R"), SimpleJewel("W"), SimpleJewel("B")),
        arrayOf<Jewel?>(SimpleJewel("B"), SimpleJewel("R"), SimpleJewel("W"), SimpleJewel("B")),
        arrayOf<Jewel?>(SimpleJewel("B"), SimpleJewel("R"), SimpleJewel("W"), SimpleJewel("B")),
        arrayOf<Jewel?>(SimpleJewel("B"), SimpleJewel("R"), SimpleJewel("R"), SimpleJewel("B")) )

        val scann = MatrixSkanner(this.matrix)



    @Test
    fun skanColumns() {
        val expected = arrayOf(
            arrayOf<Jewel?>(Bomb("B"), null, null),
            arrayOf<Jewel?>(null, SimpleJewel("R"), SimpleJewel("W")),
            arrayOf<Jewel?>(null, SimpleJewel("R"), SimpleJewel("R")) )
        scann.skanRows()
        scann.skanColumns()
        assertArrayEquals(expected, matrix)
    }

//    @Test
//    fun skanColumns1() {
//        val expected = arrayOf(
//            intArrayOf(1,2,3,4),
//            intArrayOf(1,2,3,4),
//            intArrayOf(1,2,3,4),
//            intArrayOf(1,2,3,4))
//        scann.skanColumns1(expected)
//        assertArrayEquals(expected, matrix)
//    }
}

