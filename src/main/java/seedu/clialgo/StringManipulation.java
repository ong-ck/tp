package seedu.clialgo;

import seedu.clialgo.exceptions.parser.EmptyFieldException;
import seedu.clialgo.exceptions.parser.NullInputException;

public interface StringManipulation {
    static final int MARKER_LENGTH = 2;

    /**
     * Extracts out the first word of an input string.
     *
     * @param userInput The input string.
     * @return The first word of the string.
     * @throws NullInputException If the userInput is empty or null.
     */
    static String getFirstWord(String userInput) throws NullInputException {
        if (userInput == null || userInput.equals("")) {
            throw new NullInputException();
        }
        String[] processedInputs = userInput.split(" ", 2);
        return processedInputs[0];
    }

    /**
     * Removes the first word of an input string and returns the remaining string.
     * Returns null if the string only consist of one word.
     *
     * @param userInput The input string.
     * @return The input string with the first word removed.
     * @throws NullInputException If userInput is empty or null.
     */
    static String removeFirstWord(String userInput) throws NullInputException {
        if (userInput == null || userInput.equals("")) {
            throw new NullInputException();
        }
        String[] processedInputs = userInput.split(" ", 2);
        if (processedInputs.length == 1) {
            return null;
        }
        return processedInputs[1];
    }

    /**
     * This method removes the marker from the keyword and returns the keyword.
     *
     * @param userInput The input with the marker at the front.
     * @param markerLength The length of the marker to be removed.
     * @return userInput with the marker removed at the front.
     * @throws EmptyFieldException If the string is empty after removing the keyword.
     * @throws NullInputException If userInput is empty or null.
     */
    static String removeMarker(String userInput, int markerLength) throws EmptyFieldException, NullInputException {
        if (userInput == null || userInput.equals("")) {
            throw new NullInputException();
        }
        String keyword = userInput.substring(markerLength);
        if (keyword.equals("")) {
            throw new EmptyFieldException();
        }
        return keyword;
    }
}