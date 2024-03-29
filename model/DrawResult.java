package model;

public class DrawResult {
    private int xCoordinate;
    private int yCoordinate;
    private String color;

    public DrawResult(int xCoordinate, int yCoordinate, String color) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public String getColor() {
        return this.color;
    }
}