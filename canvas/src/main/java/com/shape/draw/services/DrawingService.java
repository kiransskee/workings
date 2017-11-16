package com.shape.draw.services;


import com.shape.draw.model.Canvas;

public class DrawingService {

    int border = 2;
    char[][] canvasImage;

    public void drawCanvas(Canvas canvas)throws ArrayIndexOutOfBoundsException{
        int width = canvas.getWidth();
        int height = canvas.getHeight() + border;
        canvasImage = new char[height][width];
        for(int row = 0; row < height; row++){
            for (int col = 0 ; col < width; col++){
                if(row == 0 || row == height-1){
                    canvasImage[row][col]='-';//Top & Bottom border for Canvas
                } else if(row > 0){
                    if(col == 0 || col == width -1)
                        canvasImage[row][col]='|';//ASide & ZSide border for Canvas
                    else
                        canvasImage[row][col]=' ';
                }
            }
        }
        renderCanvas();
    }

    public void drawLine(Canvas canvas)throws ArrayIndexOutOfBoundsException{
        if(canvasImage == null){
            System.err.println("Draw Canvas first to play around.");
            return;
        }

        int yAxis1 = canvas.getLine().getCoordinateY1();
        int xAxis1 = canvas.getLine().getCoordinateX1();
        int yAxis2 = canvas.getLine().getCoordinateY2();
        int xAxis2 = canvas.getLine().getCoordinateX2();
        if(yAxis1 > canvas.getHeight() || yAxis2 > canvas.getHeight() || xAxis1 > canvas.getWidth() || xAxis2 > canvas.getWidth()){
            System.err.println("Out of Boundary, please draw line within boundary.");
            return;
        }
        if(yAxis1 <= yAxis2){ // Draws line downwards
            for(int row = yAxis1; row <= yAxis2; row++){
                drawLineForwardAndBackward(xAxis1, xAxis2, row);
            }
        } else {
            for(int row = yAxis1; row >= yAxis2; row--){
                drawLineForwardAndBackward(xAxis1, xAxis2, row);
            }
        }
        renderCanvas();
    }

    private void drawLineForwardAndBackward(int xAxis1, int xAxis2, int row) {
        if(xAxis1 <= xAxis2){ // Draws line forward
            for (int col = xAxis1 ; col <= xAxis2; col++){
                canvasImage[row][col] = 'X';
            }
        } else{ // Draws line backward
            for (int col = xAxis1 ; col >= xAxis2; col--){
                canvasImage[row][col] = 'X';
            }
        }
    }

    public void drawRectangle(Canvas canvas)throws ArrayIndexOutOfBoundsException{
        if(canvasImage == null){
            System.err.println("Draw Canvas first to play around.");
            return;
        }
        int yAxis1 = canvas.getRectangle().getCoordinateY1();
        int xAxis1 = canvas.getRectangle().getCoordinateX1();
        int yAxis2 = canvas.getRectangle().getCoordinateY2();
        int xAxis2 = canvas.getRectangle().getCoordinateX2();

        if(yAxis1 > canvas.getHeight() || yAxis2 > canvas.getHeight() || xAxis1 > canvas.getWidth() || xAxis2 > canvas.getWidth()){
            System.err.println("Out of Boundary, please draw line within boundary.");
            return;
        }
        for(int row = yAxis1; row <= yAxis2; row++){
            for (int col = xAxis1 ; col <= xAxis2; col++){
                if(row == yAxis1 || row == yAxis2){
                    canvasImage[row][col] = 'X';
                } else if(row > yAxis1){
                    if(col == xAxis1 || col == xAxis2)
                        canvasImage[row][col] = 'X';
                    else{
                        canvasImage[row][col] = ' ';
                    }
                }
            }
        }
        renderCanvas();
    }

    public void fillEmptySpaces(Canvas canvas)throws ArrayIndexOutOfBoundsException{
        if(canvasImage == null){
            System.err.println("Draw Canvas first to play around.");
            return;
        }
        int yAxis = canvas.getFillRectangle().getCoordinateY();
        int xAxis = canvas.getFillRectangle().getCoordinateX();
        char colour = canvas.getFillRectangle().getColour();
        if(yAxis > canvas.getHeight() || xAxis > canvas.getWidth()){
            System.err.println("Out of Boundary, please draw line within boundary.");
            return;
        }
        fillCanvas(xAxis, yAxis, colour, canvas);
        renderCanvas();
    }

    public void fillCanvas(int col, int row, char colour, Canvas canvas)throws ArrayIndexOutOfBoundsException{

        if(canvasImage[row][col] != ' ') {
            return;
        }
        if(col > 0 || col < canvas.getWidth() || row > 0 || row  < canvas.getHeight()) {
            if(canvasImage[row][col] == ' '){
                canvasImage[row][col] = colour;
            }
            fillCanvas(col+1,row, colour, canvas);
            fillCanvas(col-1,row, colour, canvas);
            fillCanvas(col,row-1, colour, canvas);
            fillCanvas(col,row+1, colour, canvas);
        }
    }
    public void renderCanvas(){
        for(char[] row : canvasImage) {
            for (char i : row) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
