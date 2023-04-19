package com.example.threeinarow.game.logic

interface InterfaceMatrixProcessor {

    fun fullScan()
    fun scanColumns()
    fun scanRows()

    fun activateSpecialJewels ()

    fun containsNull () :Boolean
    fun fallDown ()
    fun randomJewelGeneration()
    fun swapTwoJewels (firstJewel :Pair<Int, Int>, secondJewel :Pair<Int, Int>)
//      НАДО ЕЩЁ ФУНКЦИЮ ДЛЯ ГЕНЕРАЦИИ РАНДОМНЫХ КАМНЕЙ И ПОПУТНОГО ОПУСКАНИЯ ИХ ВНИЗ
}