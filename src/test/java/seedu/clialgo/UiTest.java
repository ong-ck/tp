package seedu.clialgo;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UiTest {

    public static final String WINDOWS_WHITESPACE = "\r\n";
    public static final String MAC_WHITESPACE = "\n";

    @Test
    void testPrintDivider() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printDivider();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintWelcomeMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printWelcomeMessage();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Hello! Welcome to CLIAlgo Notes!" + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Hello! Welcome to CLIAlgo Notes!" + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintExitMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printExitMessage();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Thank you for using CLIAlgo! Study hard!" + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Thank you for using CLIAlgo! Study hard!" + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpPage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpPage();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "The available COMMAND_TYPE(s) are:\n" +
                    "[add]: add note\n" +
                    "[remove]: remove note\n" +
                    "[list]: displays all notes\n" +
                    "[filter]: filters notes by topic\n" +
                    "[exit]: close the application\n" +
                    "For more help on a specific command, type `help c/COMMAND_TYPE`" + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "The available COMMAND_TYPE(s) are:" + MAC_WHITESPACE +
                    "[add]: add note" + MAC_WHITESPACE +
                    "[remove]: remove note" + MAC_WHITESPACE +
                    "[list]: displays all notes" + MAC_WHITESPACE +
                    "[filter]: filters notes by topic" + MAC_WHITESPACE +
                    "[exit]: close the application" + MAC_WHITESPACE +
                    "For more help on a specific command, type `help c/COMMAND_TYPE`" + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
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

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Successfully added queue into LINKED_LIST." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Successfully added queue into LINKED_LIST." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintAddFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        String topic = "FENWICK_TREE";
        ui.printAddFail(topic);

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Unsuccessful! FENWICK_TREE is not a topic in CS2040C." + WINDOWS_WHITESPACE +
                    "Type 'help c/add' for assistance." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Unsuccessful! FENWICK_TREE is not a topic in CS2040C." + MAC_WHITESPACE +
                    "Type 'help c/add' for assistance." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintListSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printListSuccess();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Here are all your notes:" + WINDOWS_WHITESPACE +
                    "======================================================" +  WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Here are all your notes:" + MAC_WHITESPACE +
                    "======================================================" +  MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintListFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printListFail();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "You have no notes!\n" +
                    "Type 'help c/add' for assistance on how to add a note." + WINDOWS_WHITESPACE +
                    "======================================================" +  WINDOWS_WHITESPACE;
        } else {
            expectedOutput =  "======================================================" + MAC_WHITESPACE +
                    "You have no notes!" + MAC_WHITESPACE +
                    "Type 'help c/add' for assistance on how to add a note." + MAC_WHITESPACE +
                    "======================================================" +  MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintRemoveSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        String name = "queue";
        ui.printRemoveSuccess(name);

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Successfully removed queue." + WINDOWS_WHITESPACE +
                    "======================================================" +  WINDOWS_WHITESPACE;
        } else {
            expectedOutput =  "======================================================" + MAC_WHITESPACE +
                    "Successfully removed queue." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintRemoveFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printRemoveFail();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" +  WINDOWS_WHITESPACE +
                    "Unsuccessful!\n" +
                    "Type 'help c/remove' for assistance on how to remove a note." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" +  MAC_WHITESPACE +
                    "Unsuccessful!" + MAC_WHITESPACE +
                    "Type 'help c/remove' for assistance on how to remove a note." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintFilterSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printFilterSuccess();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Here are the filtered notes:" + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Here are the filtered notes:" + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintFilterFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printFilterFail();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Unsuccessful!\n" +
                    "Type 'help c/filter' for assistance." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Unsuccessful!" + MAC_WHITESPACE +
                    "Type 'help c/filter' for assistance." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpAdd() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpAdd();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "This function adds a note and tags it to a topic.\n" +
                    "The syntax for the 'add' command is: add n/NAME t/TOPIC.\n" +
                    "NAME refers to the notes' file name.\n" +
                    "TOPIC refers to the topic that NAME will be tagged to.\n" +
                    "Case sensitive. NAME and TOPIC fields must be non-empty.\n" +
                    "Invalid NAME or TOPIC will cause an error.\n" +
                    "Valid TOPIC's are 'SORTING', 'LINKED_LIST', 'GRAPH_STRUCTURES',\n" +
                    "'BINARY_HEAP', 'HASH_TABLE', 'GRAPH_TRAVERSAL', 'BINARY_SEARCH_TREE',\n" +
                    "'SS_SHORTEST_PATH', 'UNION_FIND_DS' and 'MINIMUM_SPANNING_TREE'." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "This function adds a note and tags it to a topic." + MAC_WHITESPACE +
                    "The syntax for the 'add' command is: add n/NAME t/TOPIC." + MAC_WHITESPACE +
                    "NAME refers to the notes' file name." + MAC_WHITESPACE +
                    "TOPIC refers to the topic that NAME will be tagged to." + MAC_WHITESPACE +
                    "Case sensitive. NAME and TOPIC fields must be non-empty." + MAC_WHITESPACE +
                    "Invalid NAME or TOPIC will cause an error." + MAC_WHITESPACE +
                    "Valid TOPIC's are 'SORTING', 'LINKED_LIST', 'GRAPH_STRUCTURES'," + MAC_WHITESPACE +
                    "'BINARY_HEAP', 'HASH_TABLE', 'GRAPH_TRAVERSAL', 'BINARY_SEARCH_TREE'," + MAC_WHITESPACE +
                    "'SS_SHORTEST_PATH', 'UNION_FIND_DS' and 'MINIMUM_SPANNING_TREE'." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpRemove() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpRemove();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "This function removes a note from the tagged topic.\n" +
                    "The syntax for the 'remove' command is: remove n/NAME.\n" +
                    "NAME refers to the notes' file name.\n" +
                    "'n/' must be included else NAME will not be read.\n" +
                    "Invalid NAME will cause an error." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "This function removes a note from the tagged topic." + MAC_WHITESPACE +
                    "The syntax for the 'remove' command is: remove n/NAME." + MAC_WHITESPACE +
                    "NAME refers to the notes' file name." + MAC_WHITESPACE +
                    "'n/' must be included else NAME will not be read." + MAC_WHITESPACE +
                    "Invalid NAME will cause an error." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpList() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpList();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "This function lists all stored notes.\n" +
                    "The syntax for the 'list' command is: list.\n" +
                    "Command should only contain one word (i.e. no extensions)." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "This function lists all stored notes." + MAC_WHITESPACE +
                    "The syntax for the 'list' command is: list." + MAC_WHITESPACE +
                    "Command should only contain one word (i.e. no extensions)." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpFilter() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpFilter();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "This function filters by topic/importance and topic name.\n" +
                    "The syntax for the 'filter' command is: filter k/KEYWORD t/TOPIC_NAME\n" +
                    "KEYWORD has to be either 'topic' or 'importance'.\n" +
                    "TOPIC_NAME can be any (one) of the pre-defined topics in CS2040C.\n" +
                    "Case sensitive. KEYWORD and TOPIC_NAME fields must be non-empty.\n" +
                    "Invalid KEYWORD and/or TOPIC_NAME will cause an error." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "This function filters by topic/importance and topic name." + MAC_WHITESPACE +
                    "The syntax for the 'filter' command is: filter k/KEYWORD t/TOPIC_NAME" + MAC_WHITESPACE +
                    "KEYWORD has to be either 'topic' or 'importance'." + MAC_WHITESPACE +
                    "TOPIC_NAME can be any (one) of the pre-defined topics in CS2040C." + MAC_WHITESPACE +
                    "Case sensitive. KEYWORD and TOPIC_NAME fields must be non-empty." + MAC_WHITESPACE +
                    "Invalid KEYWORD and/or TOPIC_NAME will cause an error." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintHelpExit() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printHelpExit();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "This function exits the application.\n" +
                    "The syntax for the 'exit' command is: exit.\n" +
                    "Command should only contain one word (i.e. no extensions)." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "This function exits the application." + MAC_WHITESPACE +
                    "The syntax for the 'exit' command is: exit." + MAC_WHITESPACE +
                    "Command should only contain one word (i.e. no extensions)." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintInvalidCommand() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printInvalidCommand();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "This is an invalid command, please ensure all your fields are correct." + WINDOWS_WHITESPACE +
                    "Type 'help' for additional assistance." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "This is an invalid command, please ensure all your fields are correct." + MAC_WHITESPACE +
                    "Type 'help' for additional assistance." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintNameNotFoundCommand() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printNameNotFoundCommand();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Unsuccessful! A note of that name does not exist.\n" +
                    "Only notes in your list can be removed.\n" +
                    "Type 'list' to see notes you can remove." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Unsuccessful! A note of that name does not exist." + MAC_WHITESPACE +
                    "Only notes in your list can be removed." + MAC_WHITESPACE +
                    "Type 'list' to see notes you can remove." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintSaveFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();

        ui.printSaveFail();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Saving data was unsuccessful. Please try again." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Saving data was unsuccessful. Please try again." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintTestModeStart() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();

        ui.printTestModeStart();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Starting test mode." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Starting test mode." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintTestModeEnd() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printTestModeEnd();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Ending test mode." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Ending test mode." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testFileWriteError() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printFileWriteError();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "File write error." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "File write error." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testFolderCreateError() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printFolderCreateError();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Folder not created." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Folder not created." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testFileDeleteSuccess() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printFileDeleteSuccess();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Successfully deleted file." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Successfully deleted file." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testFileDeleteFail() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();
        ui.printFileDeleteFail();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Unsuccessful! Delete failed." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Unsuccessful! Delete failed." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testPrintInvalidNote() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Ui ui = new Ui();

        ui.printInvalidNote();

        String os = System.getProperty("os.name");
        String expectedOutput = "";

        if (os.contains("Windows")) {
            expectedOutput = "======================================================" + WINDOWS_WHITESPACE +
                    "Invalid note.\n" +
                    "Type 'help c/add' for how to add a note." + WINDOWS_WHITESPACE +
                    "======================================================" + WINDOWS_WHITESPACE;
        } else {
            expectedOutput = "======================================================" + MAC_WHITESPACE +
                    "Invalid note." + MAC_WHITESPACE +
                    "Type 'help c/add' for how to add a note." + MAC_WHITESPACE +
                    "======================================================" + MAC_WHITESPACE;
        }
        assertEquals(expectedOutput, outContent.toString());
    }
}
