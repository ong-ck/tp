package seedu.clialgo.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * JUnit test for the <code>AddCommand</code> class methods.
 */
class AddCommandTest {

    /**
     * Checks the <code>equals</code> method of the <code>AddCommand</code> class.
     * Inputs two equal <code>AddCommand</code> objects and expects the method to return true.
     */
    @Test
    void equals_checkEqualAddCommand_expectTrue() {
        String firstName = "dummyName";
        String secondName = "dummyName";
        String firstPath = "dummyPath";
        String secondPath = "dummyPath";
        AddCommand firstAddCommand = new AddCommand(firstName, firstPath);
        AddCommand secondAddCommand = new AddCommand(secondName, secondPath);
        assertTrue(firstAddCommand.equals(secondAddCommand));
    }

    /**
     * Checks the <code>equals</code> method of the <code>AddCommand</code> class.
     * Inputs two unequal <code>AddCommand</code> objects and expects the method to return false.
     */
    @Test
    void equals_checkUnequalAddCommand_expectFalse() {
        String firstName = "dummyName1";
        String secondName = "dummyName2";
        String firstPath = "dummyPath1";
        String secondPath = "dummyPath2";
        AddCommand firstAddCommand = new AddCommand(firstName, firstPath);
        AddCommand secondAddCommand = new AddCommand(secondName, secondPath);
        assertFalse(firstAddCommand.equals(secondAddCommand));
    }
}
