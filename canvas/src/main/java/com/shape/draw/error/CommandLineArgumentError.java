package com.shape.draw.error;


public class CommandLineArgumentError {

   public void notValidCommand(String command){
       System.err.printf("INVALID: Not a valid Command '%s', please try again ", command);
       System.out.println("\nBelow is the commands list (Case-Sensitive) and see Readme for the descriptions.");
       System.out.println("Command to Create Canvas   : 'C w h'");
       System.out.println("Command to draw Line       : 'L x1 y1 x2 y2'");
       System.out.println("Command to draw Rectangle  : 'R x1 y1 x2 y2'");
       System.out.println("Command to fill Rectangle  : 'B x y c'");
       System.out.println("Command to Quit            : 'Q'");
   }
}
