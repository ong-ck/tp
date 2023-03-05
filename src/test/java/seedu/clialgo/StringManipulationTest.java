package seedu.clialgo;

import org.junit.jupiter.api.Test;
import seedu.clialgo.exceptions.parser.EmptyFieldException;
import seedu.clialgo.exceptions.parser.NullInputException;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulationTest {
    /** Test getFirstWord */
    @Test
    void getFirstWord_normalInput_expectFirstWord() throws NullInputException {
        String twoWordsInput = "first word";
        String singleLetterFirstWordInput = "a word";
        String oneWordInput = "a";
        assertEquals(
                "first",
                StringManipulation.getFirstWord(twoWordsInput)
        );
        assertEquals(
                "a",
                StringManipulation.getFirstWord(singleLetterFirstWordInput)
        );
        assertEquals(
                "a",
                StringManipulation.getFirstWord(oneWordInput)
        );
    }

    @Test
    void getFirstWord_nullInput_expectNullInputException() {
        String noInput = "";
        String nullInput = null;
        assertThrows(
                NullInputException.class,
                () -> StringManipulation.getFirstWord(noInput)
        );
        assertThrows(
                NullInputException.class,
                () -> StringManipulation.getFirstWord(nullInput)
        );
    }

    /** Test removeFirstWord */
    @Test
    void removeFirstWord_normalInput_expectSecondWord() throws NullInputException {
        String twoWordsInput = "first word";
        String singleLetterFirstWordInput = "a word";
        String oneWordInput = "a";
        assertEquals(
                "word",
                StringManipulation.removeFirstWord(twoWordsInput)
        );
        assertEquals(
                "word",
                StringManipulation.removeFirstWord(singleLetterFirstWordInput)
        );
        assertNull(StringManipulation.removeFirstWord(oneWordInput));
    }

    @Test
    void removeFirstWord_nullInput_expectNullInputException() {
        String noInput = "";
        String nullInput = null;
        assertThrows(
                NullInputException.class,
                () -> StringManipulation.removeFirstWord(noInput)
        );
        assertThrows(
                NullInputException.class,
                () -> StringManipulation.removeFirstWord(nullInput)
        );
    }

    /** Test removeMarker */
    @Test
    void removeMarker_normalInput_expectKeyword() throws EmptyFieldException, NullInputException {
        String nameMarkerInput = "n/NAME";
        String commandMarkerInput = "c/COMMAND";
        String topicMarkerInput = "t/TOPIC";
        String keywordMarkerInput = "k/KEYWORD";
        assertEquals(
                "NAME",
                StringManipulation.removeMarker(nameMarkerInput, StringManipulation.MARKER_LENGTH)
        );
        assertEquals(
                "COMMAND",
                StringManipulation.removeMarker(commandMarkerInput, StringManipulation.MARKER_LENGTH)
        );
        assertEquals(
                "TOPIC",
                StringManipulation.removeMarker(topicMarkerInput, StringManipulation.MARKER_LENGTH)
        );
        assertEquals(
                "KEYWORD",
                StringManipulation.removeMarker(keywordMarkerInput, StringManipulation.MARKER_LENGTH)
        );
    }

    @Test
    void removeMarker_emptyFieldInput_expectEmptyFieldException() {
        String emptyFieldInput = "n/";
        assertThrows(
                EmptyFieldException.class,
                () -> StringManipulation.removeMarker(emptyFieldInput, StringManipulation.MARKER_LENGTH)
        );
    }

    @Test
    void removeMarker_nullInput_expectNullInputException() {
        String noInput = "";
        String nullInput = null;
        assertThrows(
                NullInputException.class,
                () -> StringManipulation.removeMarker(noInput, StringManipulation.MARKER_LENGTH)
        );
        assertThrows(
                NullInputException.class,
                () -> StringManipulation.removeMarker(nullInput, StringManipulation.MARKER_LENGTH)
        );
    }

}