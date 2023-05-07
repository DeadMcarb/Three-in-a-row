package com.example.threeinarow.view.LabelView;

import com.example.threeinarow.game.Game;
import javafx.scene.control.Label;

public class MovesLeftView implements View {

    private Game game;
    private Label movesLeftLabel;

    public MovesLeftView(Game game, Label movesLeftLabel) {
        this.game = game;
        this.movesLeftLabel = movesLeftLabel;
    }

    @Override
    public void update() {
        movesLeftLabel.setText("Moves left: " + game.getMovesLeft());
    }
}
