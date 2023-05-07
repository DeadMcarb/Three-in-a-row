package com.example.threeinarow.view.LabelView;

import com.example.threeinarow.game.Game;
import javafx.scene.control.Label;

public class ScoreView implements View {

    private Game game;
    private Label scoreLabel;

    public ScoreView(Game game, Label scoreLabel) {
        this.game = game;
        this.scoreLabel = scoreLabel;
    }

    @Override
    public void update() {
        scoreLabel.setText("Score: " + game.getScore());
    }
}
