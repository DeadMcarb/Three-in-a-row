package com.example.threeinarow

import com.example.threeinarow.gameField.GameField
import com.example.threeinarow.gameField.logic.InterfaceMatrixScanner
import com.example.threeinarow.gameField.logic.MatrixScanner
import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.gameFieldObjects.jewel.SimpleJewel
import com.example.threeinarow.view.GameView
import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane

///ИМПОРТ ЦВЕТОВ СИМВОЛЬНЫХ
import com.example.threeinarow.gameFieldObjects.jewel.Colors.*

class GameController {

    @FXML
    private lateinit var canvas: Canvas

    @FXML
    private lateinit var pane: Pane

    private lateinit var game: GameField
    private lateinit var view: GameView
    private lateinit var matixScanner: InterfaceMatrixScanner

    var matrix = arrayOf(
        arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(BlUE), SimpleJewel(BlUE), SimpleJewel(BlUE)),
        arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(RED), SimpleJewel(GREEN), SimpleJewel(BlUE)),
        arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(RED), SimpleJewel(GREEN), SimpleJewel(BlUE)),
        arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(RED), SimpleJewel(GREEN), SimpleJewel(BlUE)),
        arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(YELLOW), SimpleJewel(YELLOW), SimpleJewel(YELLOW)) )
    fun initialize(){
        canvas.widthProperty().bind(pane.widthProperty())
        canvas.heightProperty().bind(pane.heightProperty())

//        game = GameField()/////////////////////////////////////////
        game = GameField(5, 4 , 3000, matrix)
        //////////////////////////////////////////////////////////////////////
        view = GameView(game, canvas)
        matixScanner = MatrixScanner(game.jewelArray)

        canvas.widthProperty().addListener { _ -> view.draw() }
        canvas.heightProperty().addListener { _ -> view.draw() }

        pane.requestFocus()

        ///////////////////////
        view.drawGameField()

    }

    fun processMouseClick(mouseEvent: MouseEvent) {
        if (mouseEvent.isPrimaryButtonDown) {
            println(mouseEvent.x)
            println(mouseEvent.y)
        }
    }


    fun aaaaaaaaaaaaaa () {
        ///
        matixScanner.fullScan()
    }




}