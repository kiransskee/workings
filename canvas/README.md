# Drawing Canvas through Console

 - Two ways to run this program
 - First, Checkout as maven project and run Main Application to Start - DrawingApplication
 - Second, Build the project using maven command : mvn clean install
 - Go to target folder and run java -jar canvas-1.0-SNAPSHOT.jar

### Command  <========> Description

```bash
C w h           - Creates a new canvas with specified width w and height h.

L x1 y1 x2 y2   - Creates a new line from (x1,y1) to (x2,y2). Currently only
                  horizontal or vertical lines are supported. Horizontal and vertical lines
                  will be drawn using the 'x' character.
                
R x1 y1 x2 y2  - Creates a new rectangle, whose upper left corner is (x1,y1) and
                 lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                 using the 'x' character.
                
B x y c       -  Should fill the entire area connected to (x,y) with "colour" c. The
                 behaviour of this is the same as that of the "bucket fill" tool in paint
                 programs.
                
Q             -  Should quit the program.
```

### Sample Outputs
> Prints in Console
```
A Console Application to draw a Canvas and Play around...
Please enter the Canvas's command :
C 20 4
--------------------
|                  |
|                  |
|                  |
|                  |
--------------------
Please enter the Canvas's command :
L 1 2 6 2
--------------------
|                  |
|XXXXXX            |
|                  |
|                  |
--------------------
Please enter the Canvas's command :
L 6 3 6 4
--------------------
|                  |
|XXXXXX            |
|     X            |
|     X            |
--------------------
Please enter the Canvas's command :
R 14 1 18 3
--------------------
|             XXXXX|
|XXXXXX       X   X|
|     X       XXXXX|
|     X            |
--------------------
Please enter the Canvas's command :
B 1 1 C
--------------------
|CCCCCCCCCCCCCXXXXX|
|XXXXXXCCCCCCCX   X|
|     XCCCCCCCXXXXX|
|     XCCCCCCCCCCCC|
--------------------
Please enter the Canvas's command :
Q
Hope..! you enjoyed playing with Canvas Application.
```

<p align="center">
  <b>© Coded by Kiransskee.</b>
</p>

