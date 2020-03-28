package model;

public class TextResult extends DrawResult {
    private String text;

    public TextResult(int xCoordinate, int yCoordinate, String color, String text) {
        super(xCoordinate, yCoordinate, color);
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}