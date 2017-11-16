package com.shape.draw.services;

import com.shape.draw.model.Canvas;
import com.shape.draw.model.FillRectangle;
import com.shape.draw.model.Line;
import com.shape.draw.model.Rectangle;
import com.shape.draw.utils.CanvasUtils;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Matchers.any;

@RunWith(MockitoJUnitRunner.class)
public class DrawingServiceTest {

    @InjectMocks
    DrawingService drawingService;

    Canvas canvas;
    String command;

    @Before
    public void before() throws Exception {
        command = "L 1 2 6 2";
        canvas = new Canvas();
        canvas.setCommand('C');
        canvas.setOptions(new ArrayList<>(Arrays.asList("20","4")));
        canvas.setHeight(4);
        canvas.setWidth(20);
        canvas.setRectangle(new Rectangle());
        canvas.setFillRectangle(new FillRectangle());
        canvas.setLine(new Line());
    }

    /**
     * Method: drawCanvas(Canvas canvas)
     */
    @Test
    public void testDrawCanvas() throws Exception {
        drawingService.drawCanvas(canvas);
    }

    /**
     * Method: drawLine(Canvas canvas)
     */
    @Test
    public void testDrawLine() throws Exception {
        drawingService.drawCanvas(canvas);
        canvas.setCommand('L');
        canvas.setOptions(new ArrayList<>(Arrays.asList("1","2","6","2")));
        new CanvasUtils().setLine(canvas);
        drawingService.drawLine(canvas);
    }

    /**
     * Method: drawRectangle(Canvas canvas)
     */
    @Test
    public void testDrawRectangle() throws Exception {
        drawingService.drawCanvas(canvas);
        canvas.setCommand('R');
        canvas.setOptions(new ArrayList<>(Arrays.asList("14","1","18","3")));
        new CanvasUtils().setRectangle(canvas);
        drawingService.drawRectangle(canvas);
    }

    /**
     * Method: fillEmptySpaces(Canvas canvas)
     */
    @Test
    public void testFillEmptySpaces() throws Exception {
        drawingService.drawCanvas(canvas);
        canvas.setCommand('R');
        canvas.setOptions(new ArrayList<>(Arrays.asList("14","1","18","3")));
        new CanvasUtils().setRectangle(canvas);
        drawingService.drawRectangle(canvas);
        canvas.setCommand('B');
        canvas.setOptions(new ArrayList<>(Arrays.asList("1","1","C")));
        new CanvasUtils().setFillRectangle(canvas);
        drawingService.fillEmptySpaces(canvas);
    }

    /**
     * Method: fillCanvas(int col, int row, char colour, Canvas canvas)
     */
    @Test
    public void testFillCanvas() throws Exception {
        drawingService.drawCanvas(canvas);
        canvas.setCommand('R');
        canvas.setOptions(new ArrayList<>(Arrays.asList("14","1","18","3")));
        new CanvasUtils().setRectangle(canvas);
        drawingService.drawRectangle(canvas);
        canvas.setCommand('B');
        canvas.setOptions(new ArrayList<>(Arrays.asList("1","1","C")));
        drawingService.fillCanvas(1,1,'C', canvas);
        drawingService.renderCanvas();
    }

    /**
     * Method: renderCanvas()
     */
    @Test
    public void testRenderCanvas() throws Exception {
        drawingService.drawCanvas(canvas);
        drawingService.renderCanvas();
    }

    @Test
    public void testDrawLineWithoutCanvas() throws Exception {
        drawingService.drawLine(canvas);
    }

    @Test
    public void testDrawRectangleWithoutCanvas() throws Exception {
        drawingService.drawRectangle(canvas);
    }

    @Test
    public void testDrawLineOutOfBoundary() throws Exception {
        drawingService.drawCanvas(canvas);
        canvas.setCommand('L');
        canvas.setOptions(new ArrayList<>(Arrays.asList("1","200","60","2")));
        new CanvasUtils().setLine(canvas);
        drawingService.drawLine(canvas);
    }
}
