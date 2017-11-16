package com.shape.draw.services;


import com.shape.draw.DrawingApplication;
import com.shape.draw.error.CommandLineArgumentError;
import com.shape.draw.model.Canvas;
import com.shape.draw.utils.CanvasUtils;

public class CommandProcessorService {

    CanvasUtils utils;
    CommandLineArgumentError commandLineArgumentError;
    Canvas canvas;
    DrawingService drawingService;

    public CommandProcessorService(){
        drawingService = new DrawingService();
        canvas = new Canvas();
    }

    public void processCommand(String command)throws NumberFormatException, ArrayIndexOutOfBoundsException{
        utils = new CanvasUtils();
        canvas = utils.splitCommand(command, canvas);

        switch (canvas.getCommand()){
            case 'C': {
                utils.setCanvas(canvas);
                drawingService.drawCanvas(canvas);
                break;
            }
            case 'L': {
                utils.setLine(canvas);
                drawingService.drawLine(canvas);
                break;
            }
            case 'R': {
                utils.setRectangle(canvas);
                drawingService.drawRectangle(canvas);
                break;
            }
            case 'B': {
                utils.setFillRectangle(canvas);
                drawingService.fillEmptySpaces(canvas);
                break;
            }
            case 'Q': {
                System.out.println("Hope..! you enjoyed playing with Canvas Application.");
                System.exit(0);
            }
            default: {
                commandLineArgumentError = new CommandLineArgumentError();
                commandLineArgumentError.notValidCommand(command);
                return;
            }
        }
    }
}
