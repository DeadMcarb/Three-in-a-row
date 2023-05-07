package com.example.threeinarow.game;

import javafx.scene.control.Alert;

public class Game {

    private GameField gameField;

    private int score;

    private int movesLeft;

    private boolean running = true;


    public void scoreIncrease(int howMuchToAdd) {
        score += howMuchToAdd;
        defeatCheck();
    }

    public void movesLeftDecrease() {
        movesLeft--;
        defeatCheck();
    }
    private void defeatCheck() {
        if (movesLeft==0) {
            running = false;

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Game over!");
            alert.setTitle("Snake game");
            alert.setHeaderText(null);
            alert.show();
        }
    }


    public boolean isRunning() {
        return running;
    }

    public Game(GameField gameField, int movesLeft) {
        this.gameField = gameField;
        this.score = 0;
        this.movesLeft = movesLeft;
    }

    public Game(int verticalSize, int horizontalSize, int movesLeft) {

        this(new GameField(verticalSize, horizontalSize), movesLeft);
    }


    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    public int getScore() {
        return score;
    }

    public int getMovesLeft() {
        return movesLeft;
    }
}
