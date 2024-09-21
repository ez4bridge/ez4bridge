package main;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class JDXMTest {
    @Test
    public void testcmdController() {
        String[] args = {"-n", "10", "-r", "5"};
        Map<String, String> result = cmdController.cmdControll(args);

        assertEquals("10", result.get("-n"));
        assertEquals("5", result.get("-r"));
        assertNull(result.get("-e"));
    }

    @Test
    public void testParseEmptyArguments() {
        String[] args = {};
        Map<String, String> result = cmdController.cmdControll(args);

        assertTrue(result.isEmpty());
    }
}
