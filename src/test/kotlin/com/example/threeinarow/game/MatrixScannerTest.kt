package com.example.threeinarow.game

import com.example.threeinarow.game.logic.MatrixProcessor
import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.gameFieldObjects.jewel.SimpleJewel
import com.example.threeinarow.gameFieldObjects.jewel.Colors.*
import com.example.threeinarow.gameFieldObjects.jewel.special.Bomb
import com.example.threeinarow.gameFieldObjects.jewel.special.HorizontalLineDestroyer
import com.example.threeinarow.gameFieldObjects.jewel.special.SameColorDestroyer
import com.example.threeinarow.gameFieldObjects.jewel.special.VerticalLineDestroyer
import com.example.threeinarow.view.GameFieldFieldView
import com.example.threeinarow.view.LabelView.ScoreView
import javafx.scene.canvas.Canvas
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MatrixScannerTest {




//    @Test
//    fun testActivateSpecialJewel() {
//        var matrix = arrayOf(
//            arrayOf<Jewel?>(SimpleJewel(YELLOW), SimpleJewel(RED), SimpleJewel(GREEN), ),
//            arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(RED), VerticalLineDestroyer(YELLOW), ),
//            arrayOf<Jewel?>(SimpleJewel(BlUE), SameColorDestroyer(YELLOW), SimpleJewel(GREEN), ),
//            arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(RED), SimpleJewel(GREEN), ),
//            arrayOf<Jewel?>(Bomb(YELLOW), SimpleJewel(RED), SimpleJewel(GREEN), ) )
//
//
//
//        val game = Game(GameField(matrix), 160)
//        val canvas = Canvas()
//        val scann = MatrixProcessor(game, GameFieldFieldView(GameField(matrix), canvas), ScoreView())
//
//
//
//        val expected = arrayOf(
//            arrayOf<Jewel?>(SimpleJewel(BlUE), null, SimpleJewel(GREEN), ),
//            arrayOf<Jewel?>(SimpleJewel(BlUE), null, SimpleJewel(GREEN), ),
//            arrayOf<Jewel?>(SimpleJewel(BlUE), null, SimpleJewel(GREEN), ),
//            arrayOf<Jewel?>(SimpleJewel(BlUE), null, SimpleJewel(GREEN), ),
//            arrayOf<Jewel?>(SimpleJewel(BlUE), null, SimpleJewel(GREEN), ) )
//
//
//        scann.activateALLSpecialJewels()
//        scann.printMatrix()
//        assertArrayEquals(expected, matrix)
//    }


//    @Test
//    fun skanColumns() {
//        val expected = arrayOf(
//            arrayOf<Jewel?>(Bomb("B"), null, null),
//            arrayOf<Jewel?>(null, SimpleJewel("R"), SimpleJewel("W")),
//            arrayOf<Jewel?>(null, SimpleJewel("R"), SimpleJewel("R")) )
//        scann.scanRows()
//        scann.scanColumns()
//        assertArrayEquals(expected, matrix)
//    }

//    @Test
//    fun containsNullTEST() {
//        val newMatrix = arrayOf(
//            arrayOf<Jewel?>(Bomb("B"), null, null),
//            arrayOf<Jewel?>(null, SimpleJewel("R"), SimpleJewel("W")),
//            arrayOf<Jewel?>(null, SimpleJewel("R"), SimpleJewel("R")) )
//
//        val scann = MatrixProcessor(newMatrix)
//
//        val expected = scann.containsNull()
//        assertEquals(expected, true)
//    }


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

