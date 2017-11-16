package com.shape.draw.utils;

import com.shape.draw.model.Canvas;
import com.shape.draw.model.FillRectangle;
import com.shape.draw.model.Line;
import com.shape.draw.model.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CanvasUtils {

    List<String> commandOptions;

    public Canvas splitCommand(String command, Canvas canvas){
        if(command != null){
            commandOptions = new ArrayList<>();
            StringTokenizer scanCommand = new StringTokenizer(command);
            int counter = 0;
            while (scanCommand.hasMoreTokens()){
                if(counter == 0){
                    canvas.setCommand(scanCommand.nextToken().charAt(0));
                } else{
                    commandOptions.add(scanCommand.nextToken());
                }
                counter++;
            }
            canvas.setOptions(commandOptions);
        }
        return canvas;
    }

    public boolean isNullValid(String command){
        boolean isValid = false;
        if(command != null && command.trim() != ""){
            isValid = true;
        }
        return isValid;
    }

    public Canvas setCanvas(Canvas canvas) throws NumberFormatException{
        canvas.setWidth(Integer.parseInt(canvas.getOptions().get(0)));
        canvas.setHeight(Integer.parseInt(canvas.getOptions().get(1)));
        return canvas;
    }

    public Canvas setLine(Canvas canvas) throws NumberFormatException{
        Line line = new Line();
        line.setCoordinateX1(Integer.parseInt(canvas.getOptions().get(0)));
        line.setCoordinateY1(Integer.parseInt(canvas.getOptions().get(1)));
        line.setCoordinateX2(Integer.parseInt(canvas.getOptions().get(2)));
        line.setCoordinateY2(Integer.parseInt(canvas.getOptions().get(3)));
        canvas.setLine(line);
        return canvas;
    }

    public Canvas setRectangle(Canvas canvas)throws NumberFormatException{
        Rectangle rectangle = new Rectangle();
        rectangle.setCoordinateX1(Integer.parseInt(canvas.getOptions().get(0)));
        rectangle.setCoordinateY1(Integer.parseInt(canvas.getOptions().get(1)));
        rectangle.setCoordinateX2(Integer.parseInt(canvas.getOptions().get(2)));
        rectangle.setCoordinateY2(Integer.parseInt(canvas.getOptions().get(3)));
        canvas.setRectangle(rectangle);
        return canvas;
    }

    public Canvas setFillRectangle(Canvas canvas)throws NumberFormatException{
        FillRectangle rectangle = new FillRectangle();
        rectangle.setCoordinateX(Integer.parseInt(canvas.getOptions().get(0)));
        rectangle.setCoordinateY(Integer.parseInt(canvas.getOptions().get(1)));
        rectangle.setColour(canvas.getOptions().get(2).charAt(0));
        canvas.setFillRectangle(rectangle);
        return canvas;
    }
}
