package seedu.clialgo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

class ParserTest {
    /** Test isValidCommand */
    @Test
    void isValidCommand() {
        Parser parser = new Parser();
        ArrayList<String> correctCommands = new ArrayList<String>(
                Arrays.asList("help", "add", "remove", "filter", "exit")
        );
        ArrayList<String> wrongCommands = new ArrayList<String>(
                Arrays.asList("Help", "aDd", "remov", "filtre", "exits", "")
        );
        for (String correctCommand : correctCommands) {
            assertTrue(parser.isValidCommand(correctCommand));
        }
        for (String wrongCommand : wrongCommands) {
            assertFalse(parser.isValidCommand(wrongCommand));
        }
    }

    /** Test isCorrectMarker */
    @Test
    void isCorrectMarker_correctInput_expectTrue() {
        Parser parser = new Parser();
        String nameMarkerInput = "n/NAME";
        String commandMarkerInput = "c/COMMAND";
        String topicMarkerInput = "t/TOPIC";
        String keywordMarkerInput = "k/KEYWORD";
        assertTrue(parser.isCorrectMarker(nameMarkerInput, Parser.NAME_MARKER));
        assertTrue(parser.isCorrectMarker(commandMarkerInput, Parser.COMMAND_MARKER));
        assertTrue(parser.isCorrectMarker(topicMarkerInput, Parser.TOPIC_MARKER));
        assertTrue(parser.isCorrectMarker(keywordMarkerInput, Parser.KEYWORD_MARKER));
    }

    @Test
    void isCorrectMarker_wrongInput_expectFalse() {
        Parser parser = new Parser();
        ArrayList<String> wrongNameInputs = new ArrayList<String>(
                Arrays.asList("c/COMMAND", "t/TOPIC", "k/KEYWORD", "/nNAME", "N/NAME")
        );
        ArrayList<String> wrongCommandInputs = new ArrayList<String>(
                Arrays.asList("n/NAME", "t/TOPIC", "k/KEYWORD", "/cCOMMAND", "C/COMMAND")
        );
        ArrayList<String> wrongTopicInputs = new ArrayList<String>(
                Arrays.asList("c/COMMAND", "n/NAME", "k/KEYWORD", "/tTOPIC", "T/TOPIC")
        );
        ArrayList<String> wrongKeywordInputs = new ArrayList<String>(
                Arrays.asList("c/COMMAND", "t/TOPIC", "n/NAME", "/kKEYWORD", "K/KEYWORD")
        );

        for (String wrongNameInput : wrongNameInputs) {
            assertFalse(parser.isCorrectMarker(wrongNameInput, Parser.NAME_MARKER));
        }
        for (String wrongCommandInput : wrongCommandInputs) {
            assertFalse(parser.isCorrectMarker(wrongCommandInput, Parser.COMMAND_MARKER));
        }
        for (String wrongTopicInput : wrongTopicInputs) {
            assertFalse(parser.isCorrectMarker(wrongTopicInput, Parser.TOPIC_MARKER));
        }
        for (String wrongKeywordInput : wrongKeywordInputs) {
            assertFalse(parser.isCorrectMarker(wrongKeywordInput, Parser.KEYWORD_MARKER));
        }
    }

    @Test
    void isCorrectMarker_invalidInput_expectException() {
        Parser parser = new Parser();
        String oneLetterInput = "c";
        String emptyString = "";
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> parser.isCorrectMarker(oneLetterInput, Parser.COMMAND_MARKER)
        );
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> parser.isCorrectMarker(emptyString, Parser.COMMAND_MARKER)
        );
    }
}
