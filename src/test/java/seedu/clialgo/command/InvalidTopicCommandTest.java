package seedu.clialgo.command;

import org.junit.jupiter.api.Test;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InvalidTopicCommandTest {

    /**
     * Checks the <code>equals</code> method of the <code>InvalidTopicCommand</code> class.
     * Inputs two equal <code>InvalidTopicCommand</code> objects and expects the method to return true.
     */
    @Test
    void equals_checkEqualInvalidTopicCommand_expectTrue() {
        String firstTopic = "dummyTopic";
        String secondTopic = "dummyTopic";
        InvalidTopicCommand firstInvalidTopicCommand = new InvalidTopicCommand(firstTopic);
        InvalidTopicCommand secondInvalidTopicCommand = new InvalidTopicCommand(secondTopic);
        assertTrue(firstInvalidTopicCommand.equals(secondInvalidTopicCommand));
    }

    /**
     * Checks the <code>equals</code> method of the <code>InvalidTopicCommand</code> class.
     * Inputs two unequal <code>InvalidTopicCommand</code> objects and expects the method to return false.
     */
    @Test
    void equals_checkUnequalInvalidTopicCommand_expectFalse() {
        String firstTopic = "dummyTopic";
        String secondTopic = "diffDummyTopic";
        InvalidTopicCommand firstInvalidTopicCommand = new InvalidTopicCommand(firstTopic);
        InvalidTopicCommand secondInvalidTopicCommand = new InvalidTopicCommand(secondTopic);
        assertFalse(firstInvalidTopicCommand.equals(secondInvalidTopicCommand));
    }

    /**
     * Checks the <code>execute</code> method of the <code>InvalidTopicCommand</code> class.
     * Inputs repeated name for <code>InvalidTopicCommand</code> object and expects the method
     * to print message for unsuccessful adding of note due to invalid topic.
     */
    @Test
    void execute_checkMethodExecution_expectAddUnsuccessfulDueToInvalidTopicMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        TopicManager topicManager = new TopicManager();
        Ui ui = new Ui();
        FileManager fileManager = new FileManager();

        String topicName = "invalidTopic";
        new InvalidTopicCommand(topicName).execute(topicManager, ui, fileManager);

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            // This expected output has "File Created" due to the first
            // initialisation of the FileManager in InvalidTopicCommandTest.
            expectedOutput = "File created\r\n" +
                    "======================================================\r\n" +
                    "Unsuccessful! invalidTopic is not a topic in CS2040C.\r\n" +
                    "Type 'help c/add' for assistance.\r\n" +
                    "======================================================\r\n";
        } else {
            expectedOutput = "File created\n" +
                    "======================================================\n" +
                    "Unsuccessful! invalidTopic is not a topic in CS2040C.\n" +
                    "Type 'help c/add' for assistance.\n" +
                    "======================================================\n";
        }

        assertEquals(expectedOutput, outContent.toString());
    }
}
