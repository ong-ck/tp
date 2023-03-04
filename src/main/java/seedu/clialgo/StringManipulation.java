package seedu.clialgo;

public interface StringManipulation {
    /**
     * Extracts out the first word of an input string.
     *
     * @param userInput The input string.
     * @return The first word of the string.
     */
    static String getFirstWord(String userInput) {
        String[] processedInputs = userInput.split(" ", 2);
        return processedInputs[0];
    }

    /**
     * Removes the first word of an input string and returns the remaining string.
     * Returns null if the string only consist of one word.
     *
     * @param userInput The input string.
     * @return The input string with the first word removed.
     */
    static String removeFirstWord(String userInput) {
        String[] processedInputs = userInput.split(" ", 2);
        if (processedInputs.length == 1) {
            return null;
        }
        return processedInputs[1];
    }

    /**
     * Extracts out a sub-string from the beginning of the input string to the first occurrence delimiter.
     *
     * @param userInput The input string.
     * @param delimiter A string that is used to extract the keyword in a command.
     * @return A sub-string from the beginning of the input string to the first occurrence of delimiter.
     */
    static String getFirstDetail(String userInput, String delimiter) {
        String[] processedInputs = userInput.split(delimiter, 2);
        return processedInputs[0];
    }

    /**
     * Removes a sub-string from the beginning of the input string to the first occurrence of delimiter. This method then
     * returns the remaining string.
     * Returns null if the string only consist of one word.
     *
     * @param userInput The input string.
     * @param delimiter A string that is used to extract the keyword in a command.
     * @return The input string with the sub-string from the beginning of the input string to the first occurrence
     * of delimiter.
     */
    static String removeFirstDetail(String userInput, String delimiter) {
        String[] processedInputs = userInput.split(delimiter, 2);
        if (processedInputs.length == 1) {
            return null;
        }
        return processedInputs[1];
    }
}