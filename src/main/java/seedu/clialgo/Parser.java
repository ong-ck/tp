package seedu.clialgo;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser implements StringManipulation {
    /** List of valid commands */
    private static final ArrayList<String> COMMANDS = new ArrayList<String>(
            Arrays.asList("help", "add", "remove", "filter", "exit")
    );
    /** Delimiters use to separate inputs in commands */
    private static final String NAME_MARKER = "n/";
    private static final String COMMAND_MARKER = "c/";
    private static final String TOPIC_MARKER = "t/";
    private static final String KEYWORD_MARKER = "k/";

    /**
     * Checks if the input string is a valid command.
     *
     * @param keyWord The input string.
     * @return True if the input string is a valid keyword, False otherwise.
     */
    private boolean isValidCommand(String keyWord) {
        return COMMANDS.contains(keyWord);
    }

    /**
     * Returns the appropriate Command object based on the user input.
     *
     * @param fullCommand The full user input.
     * @param tasks The taskList containing all the tasks in Luke.
     * @return A Command objects that suits the user input.
     */
    public Command parse(String fullCommand, TaskList tasks) {
        String command = StringManipulation.getFirstWord(fullCommand);
        if (!isCommand(firstWord)) {
            return new EchoCommand(fullCommand);
        }
        String description = StringManipulation.removeFirstWord(fullCommand);
        return prepareCommand(firstWord, description, tasks);
    }

}

