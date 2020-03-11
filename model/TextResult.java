package model;

import javafx.scene.paint.Color;

public class TextResult extends DrawResult {
    private String text;

    public TextResult(int xCoordinate, int yCoordinate, Color color, String text) {
        super(xCoordinate, yCoordinate, color);

        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}