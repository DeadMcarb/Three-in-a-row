package com.example.threeinarow.game.logic

import com.example.threeinarow.gameFieldObjects.jewel.Jewel

interface InterfaceMatrixProcessor {

    fun fullScan()
    fun scanColumns()
    fun scanRows()

    fun activateALLSpecialJewels ()

    fun fallDown ()
    fun randomJewelGeneration(): Jewel
    fun swapTwoJewels (firstJewel :Pair<Int, Int>, secondJewel :Pair<Int, Int>)

}