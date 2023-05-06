package com.example.threeinarow

import com.example.threeinarow.game.Game
import com.example.threeinarow.game.GameField
import com.example.threeinarow.game.logic.InterfaceMatrixProcessor
import com.example.threeinarow.game.logic.InterfaceMouseProcessor
import com.example.threeinarow.game.logic.MatrixProcessor
import com.example.threeinarow.game.logic.MouseProcessor
import com.example.threeinarow.gameFieldObjects.jewel.Jewel
import com.example.threeinarow.gameFieldObjects.jewel.SimpleJewel
import com.example.threeinarow.view.GameFieldFieldView
import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.input.MouseEvent
import javafx.scene.layout.Pane

///ИМПОРТ ЦВЕТОВ СИМВОЛЬНЫХ
import com.example.threeinarow.gameFieldObjects.jewel.Colors.*
import com.example.threeinarow.gameFieldObjects.jewel.special.Bomb
import com.example.threeinarow.gameFieldObjects.jewel.special.HorizontalLineDestroyer
import com.example.threeinarow.gameFieldObjects.jewel.special.SameColorDestroyer
import com.example.threeinarow.gameFieldObjects.jewel.special.VerticalLineDestroyer
import com.example.threeinarow.view.LabelView.ScoreView
import javafx.scene.input.MouseButton


class GameController {

    @FXML
    private lateinit var canvas: Canvas

    @FXML
    private lateinit var pane: Pane

    private lateinit var game: Game
    private lateinit var gameField: GameField
    private lateinit var gameFieldFieldView: GameFieldFieldView
    private lateinit var matixScanner: InterfaceMatrixProcessor
    private lateinit var mouseProcessor: InterfaceMouseProcessor

    var matrix = arrayOf(
        arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(YELLOW), SimpleJewel(BlUE), SimpleJewel(BlUE)),
        arrayOf<Jewel?>(SimpleJewel(YELLOW), SimpleJewel(RED), SimpleJewel(GREEN), SimpleJewel(RED)),
        arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(RED), SimpleJewel(GREEN), SimpleJewel(BlUE)),
        arrayOf<Jewel?>(SimpleJewel(BlUE), SimpleJewel(YELLOW), SimpleJewel(BlUE), SimpleJewel(YELLOW)) )
    fun initialize(){
        canvas.widthProperty().bind(pane.widthProperty())
        canvas.heightProperty().bind(pane.heightProperty())

//        game = Game()/////////////////////////////////////////
        gameField = GameField(matrix.size,matrix[0].size, matrix)
        game = Game(gameField, 1500)
        //////////////////////////////////////////////////////////////////////
        gameFieldFieldView = GameFieldFieldView(gameField, canvas)
        val scoreView = ScoreView()
        matixScanner = MatrixProcessor(game, gameFieldFieldView, scoreView)



        canvas.widthProperty().addListener { _ -> gameFieldFieldView.update() } // добавить сюда абдейт и других вьювов
        canvas.heightProperty().addListener { _ -> gameFieldFieldView.update() }

        pane.requestFocus()

        ///////////////////////
        gameFieldFieldView.update()

        mouseProcessor = MouseProcessor(gameField, gameFieldFieldView, matixScanner)


    }

    fun processMouseClick(mouseEvent: MouseEvent) {
        if (mouseEvent.button == MouseButton.PRIMARY) {
            mouseProcessor.process(mouseEvent.x, mouseEvent.y)
        }
    }


}