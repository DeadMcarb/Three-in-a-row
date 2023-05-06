package com.example.threeinarow.game;

import com.example.threeinarow.gameFieldObjects.jewel.Jewel;

public class Game {

    private GameField gameField;

    private int score;
    //За каждый элемент в списке для удаления будет давать n очков

    private int timeLeft;

    public Game(GameField gameField, int timeLeft) {
        this.gameField = gameField;
        this.score = 0;
        this.timeLeft = timeLeft;
    }

    public Game(int verticalSize, int horizontalSize, int timeLeft) {

        this(new GameField(verticalSize, horizontalSize), timeLeft);
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

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public int getScore() {
        return score;
    }

    public int getTimeLeft() {
        return timeLeft;
    }
}
