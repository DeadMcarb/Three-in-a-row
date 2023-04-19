package com.example.threeinarow.game.logic

interface InterfaceMouseProcessor {
    fun process(x:Double, y:Double)

    fun isBeyondGameField (x:Double, y:Double): Boolean

    fun identifyJewel(x: Double, y: Double): Pair<Int, Int>


    fun checkNeighbours():Boolean
}