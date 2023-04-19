package com.example.threeinarow.view

import com.example.threeinarow.gameFieldObjects.jewel.Jewel

interface InterfaceGameFieldView {
    fun draw()

    fun drawGameField()

    fun highlightJewel(jewelij: Pair<Int, Int>)
    fun drawOneJewel(i: Int, j: Int)

    fun clear()
}