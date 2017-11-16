package com.shape.draw;

import com.shape.draw.error.CommandLineArgumentError;
import com.shape.draw.services.CommandProcessorService;
import com.shape.draw.utils.CanvasUtils;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DrawingApplication {

    CanvasUtils utils;
    CommandProcessorService commandProcessorService;
    CommandLineArgumentError commandLineArgumentError;
    Scanner scanner;

    public static void main(String[] args) {
        System.out.println("A Console Application to draw a Canvas and Play around...");
        new DrawingApplication().executeCommand();
    }

    public void executeCommand(){

        utils = new CanvasUtils();
        commandProcessorService = new CommandProcessorService();
        // create a scanner to read the command-line input
        if(scanner == null)
            scanner = new Scanner(System.in);
        while(true){
            //  prompt for command
            System.out.print("Please enter the Canvas's command :\n");
            handleInputCommand(scanner);
        }
    }

    private void handleInputCommand(Scanner scanner) {
        commandLineArgumentError = new CommandLineArgumentError();
        String createCommand = "Q"; //Default Quit Command
        if(scanner.hasNextLine())
            createCommand = scanner.nextLine();
        if(!utils.isNullValid(createCommand)){
            commandLineArgumentError.notValidCommand(createCommand);
            executeCommand();
        } else {
            try {
                commandProcessorService.processCommand(createCommand);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException | NoSuchElementException cmdEx){
                commandLineArgumentError.notValidCommand(createCommand);
            }  catch (Exception ex){
                commandLineArgumentError.notValidCommand(createCommand);
            }
        }
    }
}
