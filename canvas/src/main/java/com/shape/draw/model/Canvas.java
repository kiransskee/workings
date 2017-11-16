package com.shape.draw.model;


import java.util.List;

public class Canvas {
    private char command;
    private int width;
    private int height;
    private Line line;
    private Rectangle rectangle;
    private FillRectangle fillRectangle;
    private List<String> options;

    public char getCommand() {
        return command;
    }

    public void setCommand(char command) {
        this.command = command;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public FillRectangle getFillRectangle() {
        return fillRectangle;
    }

    public void setFillRectangle(FillRectangle fillRectangle) {
        this.fillRectangle = fillRectangle;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
