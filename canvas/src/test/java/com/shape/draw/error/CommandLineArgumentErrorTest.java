package com.shape.draw.error;

import com.shape.draw.error.CommandLineArgumentError;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandLineArgumentErrorTest {

    @InjectMocks
    CommandLineArgumentError commandLineArgumentError;
    /**
     * Method: notValidCommand(String command)
     */
    @Test
    public void testNotValidCommand() throws Exception {
        commandLineArgumentError.notValidCommand("T 20 4");
    }
}
