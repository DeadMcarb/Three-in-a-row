package com.example.threeinarow.view

import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.view.LabelView.View

interface InterfaceGameFieldView : View{


    fun drawGameField()

    fun highlightJewel(jewelij: Pair<Int, Int>)
    fun drawOneJewel(i: Int, j: Int)

    fun clear()
}