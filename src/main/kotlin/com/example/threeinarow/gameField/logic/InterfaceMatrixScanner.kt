package com.example.threeinarow.gameField.logic

interface InterfaceMatrixScanner {

    fun fullScan()
    fun scanColumns()
    fun scanRows()

    fun activateSpecialJewels ()

    fun containsNull () :Boolean
    fun fallDown ()
    fun randomJewelGeneration()
    fun swapTwoJewels ()
//      НАДО ЕЩЁ ФУНКЦИЮ ДЛЯ ГЕНЕРАЦИИ РАНДОМНЫХ КАМНЕЙ И ПОПУТНОГО ОПУСКАНИЯ ИХ ВНИЗ
}