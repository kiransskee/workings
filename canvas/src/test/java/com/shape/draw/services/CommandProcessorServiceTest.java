package com.shape.draw.services;

import com.shape.draw.DrawingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandProcessorServiceTest {

    @InjectMocks
    CommandProcessorService commandProcessorService;

    /**
     * Method: processCommand(String command)
     */
    @Test
    public void testProcessCommand() throws Exception {
        commandProcessorService.processCommand("C 20 4");
    }

    @Test
    public void testInvalidCommand() throws Exception {
        commandProcessorService.processCommand("T 20 4");
    }
}
