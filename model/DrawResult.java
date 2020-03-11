package model;

import javafx.scene.paint.Color;

public class DrawResult {
    private int xCoordinate;
    private int yCoordinate;
    private Color color;

    public DrawResult(int xCoordinate, int yCoordinate, Color color) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}