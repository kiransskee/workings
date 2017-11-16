package com.shape.draw.utils;

import com.shape.draw.model.Canvas;
import com.shape.draw.model.FillRectangle;
import com.shape.draw.model.Line;
import com.shape.draw.model.Rectangle;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class CanvasUtilsTest {

    Canvas canvas;

    @InjectMocks
    CanvasUtils canvasUtils;

    String command;

    @Before
    public void before() throws Exception {
        command = "C 40 6";
        canvas = new Canvas();
        canvas.setCommand('L');
        canvas.setOptions(new ArrayList<>(Arrays.asList("3","3","3","3")));
        canvas.setHeight(4);
        canvas.setWidth(20);
        canvas.setRectangle(new Rectangle());
        canvas.setFillRectangle(new FillRectangle());
        canvas.setLine(new Line());
    }

    /**
     * Method: splitCommand(String command, Canvas canvas)
     */
    @Test
    public void testSplitCommand() throws Exception {

        canvasUtils.splitCommand(command, canvas);
    }

    /**
     * Method: isNullValid(String command)
     */
    @Test
    public void testIsValidCommandWithOptions() throws Exception {
        canvasUtils.isNullValid(command);
    }

    /**
     * Method: setCanvas(Canvas canvas)
     */
    @Test
    public void testSetCanvas() throws Exception {
        canvasUtils.setCanvas(canvas);
    }

    /**
     * Method: setLine(Canvas canvas)
     */
    @Test
    public void testSetLine() throws Exception {
        canvasUtils.setLine(canvas);
    }

    /**
     * Method: setRectangle(Canvas canvas)
     */
    @Test
    public void testSetRectangle() throws Exception {
        canvasUtils.setRectangle(canvas);
    }

    /**
     * Method: setFillRectangle(Canvas canvas)
     */
    @Test
    public void testSetFillRectangle() throws Exception {
        canvasUtils.setFillRectangle(canvas);
    }
}
