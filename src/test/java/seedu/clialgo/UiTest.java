package seedu.clialgo;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UiTest {

    @Test
    void testPrintWelcomeMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printWelcomeMessage();

        String expectedOutput = "======================================================\n" +
                "Hello! Welcome to CLIAlgo Notes!\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintExitMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printExitMessage();

        String expectedOutput = "======================================================\n" +
                "Thank you for using CLIAlgo! Study hard!\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpPage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpPage();

        String expectedOutput = "======================================================\n" +
                "The available COMMAND_TYPE(s) are:\n" +
                "[add]: add note\n" +
                "[remove]: remove note\n" +
                "[list]: displays all notes\n" +
                "[filter]: filters notes by topic\n" +
                "[exit]: close the application\n" +
                "For more help on a specific command, type `help c/COMMAND_TYPE`\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintAddSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        String name = "queue";
        String topic = "LINKED_LIST";
        ui.printAddSuccess(name, topic);

        String expectedOutput = "======================================================\n" +
                "Successfully added queue into LINKED_LIST.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintAddFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        String topic = "FENWICK_TREE";
        ui.printAddFail(topic);

        String expectedOutput = "======================================================\n" +
                "Unsuccessful! FENWICK_TREE is not a topic in CS2040C.\n" +
                "Type 'help c/add' for assistance.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintListSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printListSuccess();

        String expectedOutput = "======================================================\n" +
                "Here are all your notes:\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintListFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printListFail();

        String expectedOutput = "======================================================\n" +
                "You have no notes!\n" +
                "Type 'help c/list' for assistance.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintRemoveSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        String name = "queue";
        ui.printRemoveSuccess(name);

        String expectedOutput = "======================================================\n" +
                "Successfully removed queue.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintRemoveFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printRemoveFail();

        String expectedOutput = "======================================================\n" +
                "Unsuccessful!\n" +
                "Type 'help c/remove' for assistance.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintFilterSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printFilterSuccess();

        String expectedOutput = "======================================================\n" +
                "Here are the filtered notes:\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintFilterFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printFilterFail();

        String expectedOutput = "======================================================\n" +
                "Unsuccessful!\n" +
                "Type 'help c/filter' for assistance.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpAdd() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpAdd();

        String expectedOutput = "======================================================\n" +
                "This function adds a note and tags it to a topic.\n" +
                "The syntax for the 'add' command is: add n/NAME t/TOPIC. \n" +
                "NAME refers to the notes' file name.\n" +
                "TOPIC refers to the topic that NAME will be tagged to.\n" +
                "Case sensitive. NAME and TOPIC fields must be non-empty.\n" +
                "Invalid NAME or TOPIC will cause an error.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpRemove() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpRemove();

        String expectedOutput = "======================================================\n" +
                "This function removes a note from the tagged topic.\n" +
                "The syntax for the 'remove' command is: remove n/NAME. \n" +
                "NAME refers to the notes' file name.\n" +
                "'n/' must be included else NAME will not be read.\n" +
                "Invalid NAME will cause an error.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpList();

        String expectedOutput = "======================================================\n" +
                "This function lists all stored notes.\n" +
                "The syntax for the 'list' command is: list.\n" +
                "Command should only contain one word (i.e. no extensions).\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpFilter() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpFilter();

        String expectedOutput = "======================================================\n" +
                "This function filters by topic/importance and topic name.\n" +
                "The syntax for the 'filter' command is: filter k/KEYWORD t/TOPIC_NAME\n" +
                "KEYWORD has to be either 'topic' or 'importance'.\n" +
                "TOPIC_NAME can be any (one) of the pre-defined topics in CS2040C.\n" +
                "Case sensitive. KEYWORD and TOPIC_NAME fields must be non-empty.\n" +
                "Invalid KEYWORD and/or TOPIC_NAME will cause an error.\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpExit() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpExit();

        String expectedOutput = "======================================================\n" +
                "This function exits the application.\n" +
                "The syntax for the 'exit' command is: exit.\n" +
                "Command should only contain one word (i.e. no extensions).\n" +
                "======================================================\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
