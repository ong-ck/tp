package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveCommandTest {
    @Test
    public void testRemoveCommandConstructor() {
        RemoveCommand myObj = new RemoveCommand("queue notes");
        assertEquals("queue notes", myObj.name);
    }
}