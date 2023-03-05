package seedu.clialgo;

import seedu.clialgo.exceptions.parser.EmptyFieldException;
import seedu.clialgo.exceptions.parser.NullInputException;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser implements StringManipulation {
    /** List of valid commands */
    private static final ArrayList<String> COMMANDS = new ArrayList<String>(
            Arrays.asList("help", "add", "remove", "filter", "exit")
    );

    /** Delimiters use to separate inputs in commands */
    public static final String NAME_MARKER = "n/";
    public static final String COMMAND_MARKER = "c/";
    public static final String TOPIC_MARKER = "t/";
    public static final String KEYWORD_MARKER = "k/";
    public static final String WHITE_SPACE = " ";

    /**
     * Checks if the input string is a valid command.
     *
     * @param keyWord The input string.
     * @return True if the input string is a valid keyword, False otherwise.
     */
    public boolean isValidCommand(String keyWord) {
        return COMMANDS.contains(keyWord);
    }

    /**
     * Checks if the correct marker is used by the user.
     *
     * @param userInput The input string by the user.
     * @param correctMarker The correct marker that is supposed to be used.
     * @return True if the marker used by the user matches correctMarker. False otherwise.
     * @throws IndexOutOfBoundsException If length of userInput < length of correctMarker.
     */
    public boolean isCorrectMarker(String userInput, String correctMarker) throws IndexOutOfBoundsException {
        String markerPresent = userInput.substring(0, correctMarker.length());
        return markerPresent.equals(correctMarker);
    }

    /**
     * Returns a <code>HelpCommand</code> object that teaches the user how to use CLIAlgo when executed.
     * Returns a <code>HelpCommand</code> using the default constructor if description is empty.
     * Returns <code>InvalidCommand</code> when the user does not follow the input format in the user guide.
     *
     * @param description A string indicating the command the user need help with.
     * @return A Command object that teaches the user how to use CLIAlgo when executed.
     */
    private Command prepareHelpCommand(String description) {
        // No description provided, show generic help message.
        if (description == null || description.equals("")) {
            return new HelpCommand();
        }
        String command;
        try {
            if (!isCorrectMarker(description, COMMAND_MARKER)) {
                return new InvalidCommand();
            }

            command = StringManipulation.removeMarker(description, COMMAND_MARKER);

            if (!isValidCommand(command)) {
                return new InvalidCommand();
            }
        } catch (IndexOutOfBoundsException | EmptyFieldException | NullInputException e) {
            return new InvalidCommand();
        }
        return new HelpCommand(command);
    }

    /**
     * Returns a <code>AddCommand</code> object that adds a note to CLIAlgo when executed.
     * Returns <code>InvalidCommand</code> when the user does not follow the input format in the user guide.
     *
     * @param description String containing the information on the note to be added.
     * @param topics The topic manager class containing all topics in CLIAlgo.
     * @return a Command object that adds a note to CLIAlgo when executed.
     */
    private Command prepareAddCommand(String description, TopicManager topics) {
        if (description == null) {
            return new InvalidCommand();
        }
        String noteName, topicName;
        try {
            noteName = StringManipulation.getFirstWord(description, TOPIC_MARKER);
            topicName = StringManipulation.removeFirstWord(description, TOPIC_MARKER);
            if (!topics.isValidTopic(topicName)) {
                return new InvalidTopicCommand();
            }
        } catch (NullInputException e) {
            return new InvalidCommand();
        }
        return new AddCommand(noteName, topicName);
    }

    /**
     * Returns a <code>RemoveCommand</code> object that deletes a note from CLIAlgo when executed.
     * Returns <code>InvalidCommand</code> when the user does not follow the input format in the user guide.
     *
     * @param description String containing the information on the note to be removed.
     * @param topics The topic manager class containing all topics in CLIAlgo.
     * @return a Command object that deletes a note from CLIAlgo when executed.
     */
    private Command prepareRemoveCommand(String description, TopicManager topics) {
        if (description == null) {
            return new InvalidCommand();
        }
        String noteName;
        try {
            if (!isCorrectMarker(description, NAME_MARKER)) {
                return new InvalidCommand();
            }
            noteName = StringManipulation.removeMarker(description, NAME_MARKER);
        } catch (NullInputException | EmptyFieldException e) {
            return new InvalidCommand();
        }
        return new RemoveCommand(noteName);
    }

    /**
     * Returns a <code>FilterCommand</code> object that lists notes according a certain criteria.
     * Returns <code>InvalidCommand</code> when the user does not follow the input format in the user guide.
     *
     * @param description String containing criteria to filter the notes by.
     * @param topics The topic manager class containing all topics in CLIAlgo.
     * @return a Command object that lists notes according a certain criteria.
     */
    private Command prepareFilterCommand(String description, TopicManager topics) {
        if (description == null) {
            return new InvalidCommand();
        }
        String keyWord, topicName;
        try {
            String fullKeyWord = StringManipulation.getFirstWord(description, TOPIC_MARKER);
            topicName = StringManipulation.removeFirstWord(description, TOPIC_MARKER);
            if (!isCorrectMarker(fullKeyWord, KEYWORD_MARKER)) {
                return new InvalidCommand();
            }
            keyWord = StringManipulation.removeMarker(fullKeyWord, KEYWORD_MARKER);
        } catch (NullInputException | EmptyFieldException e) {
            return new InvalidCommand();
        }
        return new FilterCommand(keyWord, topicName);
    }

    /**
     * @return A <code>Command</code> object that list out the notes stored in CLIAlgo.
     */
    private Command prepareListCommand() {
        return new ListCommand();
    }

    /**
     * @return A <code>Command</code> object that exits CLIAlgo.
     */
    private Command prepareExitCommand() {
        return new ExitCommand();
    }

    /**
     * This function takes in the command keyword and description and executes the specified command.
     *
     * @param command The command keyword indicating the type of command to execute.
     * @param description The string specifying the details of the command.
     * @param topics The topic manager class containing all topics in CLIAlgo.
     * @return A Command object that executes the command corresponding to the command keyword keyed in by the user.
     */
    private Command prepareCommand(String command, String description, TopicManager topics) {
        switch (command) {
        case "help":
            return prepareHelpCommand(description);
        case "add":
            return prepareAddCommand(description, topics);
        case "remove":
            return prepareRemoveCommand(description, topics);
        case "filter":
            return prepareFilterCommand(description, topics);
        case "list":
            return prepareListCommand();
        default:
            return prepareExitCommand();
        }
    }

    /**
     * Returns the appropriate Command object based on the user input.
     *
     * @param fullCommand The full user input.
     * @param topics The topic manager class containing all topics in CLIAlgo.
     * @return A Command objects that suits the user input.
     */
    public Command parse(String fullCommand, TopicManager topics) {
        String command, description;
        try {
            command = StringManipulation.getFirstWord(fullCommand, WHITE_SPACE);
            if (!isValidCommand(command)) {
                return new InvalidCommand();
            }
            description = StringManipulation.removeFirstWord(fullCommand, WHITE_SPACE);

        } catch (NullInputException e) {
            return new InvalidCommand();
        }
        return prepareCommand(command, description, topics);
    }}