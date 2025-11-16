package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAppConstructor() {
        try {
            new App();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }

    @Test
    public void testAppMain()
    {
        App.main(null);
        try {
            String expectedOutput = "Hello World!" + System.getProperty("line.separator");
            for (int i = 1; i <= 10; i++) {
                expectedOutput += i + System.getProperty("line.separator");
            }
            assertEquals(expectedOutput, outContent.toString());
        } catch (AssertionError e) {
            fail("Output does not match expected format with loop from 1 to 10");
        }
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
