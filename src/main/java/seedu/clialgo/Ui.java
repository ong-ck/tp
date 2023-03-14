package seedu.clialgo;

import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class Ui {

    private static final String DIVIDER = "======================================================";

    /**
     * Scanner object to read user input.
     */
    private final Scanner in;

    public Ui() {
        in = new Scanner(System.in);
    }

    /**
     * Returns user input
     *
     * @return userInput A String input by the user
     */
    public String getUserInput() {
        return in.nextLine();
    }

    /**
     * Prints a divider
     */
    public void printDivider() {
        System.out.println(DIVIDER);
    }

    /**
     * Prints the intro message when application starts
     */
    public void printWelcomeMessage() {
        printDivider();
        System.out.println("Hello! Welcome to CLIAlgo Notes!");
        printDivider();
    }

    /**
     * Prints the outro message when the application is closed
     */
    public void printExitMessage() {
        printDivider();
        System.out.println("Thank you for using CLIAlgo! Study hard!");
        printDivider();
    }

    /**
     * Prints a list of valid (available) user commands
     * To be called when userInput.equals("help")
     */
    public void printHelpPage() {
        printDivider();
        System.out.println("The available COMMAND_TYPE(s) are:\n" +
                        "[add]: add note\n" +
                        "[remove]: remove note\n" +
                        "[list]: displays all notes\n" +
                        "[filter]: filters notes by topic\n" +
                        "[exit]: close the application\n" +
                        "For more help on a specific command, type `help c/COMMAND_TYPE`");
        printDivider();
    }

    /**
     * Prints a message indicating successful addition of the notes to the tagged topic in the list
     *
     * @param name the name of the notes defined by the user
     * @param topic the CS2040C topic
     */
    public void printAddSuccess(String name, String topic) {
        printDivider();
        System.out.printf("Successfully added %s into %s.%n", name, topic);
        printDivider();
    }

    /**
     * Prints a message indicating the failure to add notes to a topic (which does not exist in CS2040)
     *
     * @param topic the CS2040C topic
     */
    public void printAddFail(String topic) {
        printDivider();
        System.out.printf("Unsuccessful! %s is not a topic in CS2040C.%n", topic);
        System.out.println("Type 'help c/add' for assistance.");
        printDivider();
    }

    public void printNoteExists() {
        printDivider();
        System.out.println("Unsuccessful! A note with that name already exists.\n" +
                        "Type 'list' to view the list of notes.");
        printDivider();
    }

    /**
     * Prints the list of notes saved by the user
     */
    public void printListSuccess() {
        printDivider();
        System.out.println("Here are all your notes:");
        printDivider();
    }

    /**
     * Prints an error message if user has no saved notes
     */
    public void printListFail() {
        printDivider();
        System.out.println("You have no notes!\n" +
                        "Type 'help c/add' for assistance on how to add a note.");
        printDivider();
    }

    /**
     * Prints a message indicating successful purge of a user-defined notes
     *
     * @param name the name of the notes defined by the user
     */
    public void printRemoveSuccess(String name) {
        printDivider();
        System.out.printf("Successfully removed %s.%n", name);
        printDivider();
    }

    /**
     * Prints an error message if user has not used appropriate flags/no notes exist of the specific name
     */
    public void printRemoveFail() {
        printDivider();
        System.out.println("Unsuccessful!\n" +
                        "Type 'help c/remove' for assistance on how to remove a note.");
        printDivider();
    }

    /**
     * Prints a filtered set of notes user-specified by keyword and topic name
     */
    public void printFilterSuccess() {
        printDivider();
        System.out.println("Here are the filtered notes:");
        printDivider();
    }

    /**
     * Prints a filtered set of notes user-specified by keyword and topic name
     */
    public void printFilterFail() {
        printDivider();
        System.out.println("Unsuccessful!\n" +
                        "Type 'help c/filter' for assistance.");
        printDivider();
    }

    /**
     * Prints the requirements for using the 'add' command
     * To be called when userInput.equals("help c/add")
     */
    public void printHelpAdd() {
        printDivider();
        System.out.println("This function adds a note and tags it to a topic.\n" +
                        "The syntax for the 'add' command is: add n/NAME t/TOPIC.\n" +
                        "NAME refers to the notes' file name.\n" +
                        "TOPIC refers to the topic that NAME will be tagged to.\n" +
                        "Case sensitive. NAME and TOPIC fields must be non-empty.\n" +
                        "Invalid NAME or TOPIC will cause an error.\n" +
                        "Valid TOPIC's are 'SORTING', 'LINKED_LIST', 'GRAPH_STRUCTURES',\n" +
                        "'BINARY_HEAP', 'HASH_TABLE', 'GRAPH_TRAVERSAL', 'BINARY_SEARCH_TREE',\n" +
                        "'SS_SHORTEST_PATH', 'UNION_FIND_DS' and 'MINIMUM_SPANNING_TREE'.");
        printDivider();
    }

    /**
     * Prints the requirements for using the 'remove' command
     * To be called when userInput.equals("help c/remove")
     */
    public void printHelpRemove() {
        printDivider();
        System.out.println("This function removes a note from the tagged topic.\n" +
                        "The syntax for the 'remove' command is: remove n/NAME.\n" +
                        "NAME refers to the notes' file name.\n" +
                        "'n/' must be included else NAME will not be read.\n" +
                        "Invalid NAME will cause an error.");
        printDivider();
    }

    /**
     * Prints the requirements for using the 'list' command
     * To be called when userInput.equals("help c/list")
     */
    public void printHelpList() {
        printDivider();
        System.out.println("This function lists all stored notes.\n" +
                        "The syntax for the 'list' command is: list.\n" +
                        "Command should only contain one word (i.e. no extensions).");
        printDivider();
    }

    /**
     * Prints the requirements for using the 'filter' command
     * To be called when userInput.equals("help c/filter")
     */
    public void printHelpFilter() {
        printDivider();
        System.out.println("This function filters by topic/importance and topic name.\n" +
                        "The syntax for the 'filter' command is: filter k/KEYWORD t/TOPIC_NAME\n" +
                        "KEYWORD has to be either 'topic' or 'importance'.\n" +
                        "TOPIC_NAME can be any (one) of the pre-defined topics in CS2040C.\n" +
                        "Case sensitive. KEYWORD and TOPIC_NAME fields must be non-empty.\n" +
                        "Invalid KEYWORD and/or TOPIC_NAME will cause an error.");
        printDivider();
    }

    /**
     * Prints the requirements for using the 'exit' command
     * To be called when userInput.equals("help c/exit")
     */
    public void printHelpExit() {
        printDivider();
        System.out.println("This function exits the application.\n" +
                        "The syntax for the 'exit' command is: exit.\n" +
                        "Command should only contain one word (i.e. no extensions).");
        printDivider();
    }

    /**
     * Prints an error message indicating invalid user-input
     */
    public void printInvalidCommand() {
        printDivider();
        System.out.println("This is an invalid command, please ensure all your fields are correct.");
        System.out.println("Type 'help' for additional assistance.");
        printDivider();
    }

    /**
     * Close the System.in scanner
     */
    public void closeScanner() {
        this.in.close();
    }

    /**
     * Prints an error message when the user tries to remove a file whose name does not exist
     */
    public void printNameNotFoundCommand() {
        printDivider();
        System.out.println("Unsuccessful! A note of that name does not exist.\n" +
                        "Only notes in your list can be removed.\n" +
                        "Type 'list' to see notes you can remove.");
        printDivider();
    }

    /**
     * Prints an error message when saving data is unsuccessful.
     */
    public void printSaveFail() {
        printDivider();
        System.out.println("Saving data was unsuccessful. Please try again.");
        printDivider();
    }

    /**
     * Prints a message indicating the start of test mode.
     */
    public void printTestModeStart() {
        printDivider();
        System.out.println("Starting test mode.");
        printDivider();
    }

    /**
     * Prints a message indicating the end of test mode.
     */
    public void printTestModeEnd() {
        printDivider();
        System.out.println("Ending test mode.");
        printDivider();
    }

    /**
     * Prints an error message indicating failure to write to file.
     */
    public void printFileWriteError() {
        printDivider();
        System.out.println("File write error.");
        printDivider();
    }

    /**
     * Prints an error message indicating failure to create folder.
     */
    public void printFolderCreateError() {
        printDivider();
        System.out.println("Folder not created.");
        printDivider();
    }

    /**
     * Prints an error message indicating file delete success.
     */
    public void printFileDeleteSuccess() {
        printDivider();
        System.out.println("Successfully deleted file.");
        printDivider();
    }

    /**
     * Prints an error message indicating failure to delete the file.
     */
    public void printFileDeleteFail() {
        printDivider();
        System.out.println("Unsuccessful! Delete failed.");
        printDivider();
    }

    /**
     * Prints an error message indicating that note is invalid.
     */
    public void printInvalidNote() {
        printDivider();
        System.out.println("Invalid note.\n" +
                        "Type 'help c/add' for how to add a note.");
        printDivider();
    }
}
