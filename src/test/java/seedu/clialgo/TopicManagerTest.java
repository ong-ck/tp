package seedu.clialgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopicManagerTest {

    /**
     * Checks the <code>addNote</code> method of the <code>TopicManager</code> class.
     * Inputs proper inputs for <code>addNote</code> method and expects the method
     * to return True.
     */
    @Test
    void addNote_checkProperInput_expectTrue() {
        String noteName = "dummyName";
        String topicName = "SORTING";
        Note note = new Note(noteName, noteName + ".txt", topicName);
        assertTrue(new TopicManager().addNote(noteName, topicName, note));
    }

    /**
     * Checks the <code>addNote</code> method of the <code>TopicManager</code> class.
     * Inputs repeated name for <code>TopicManager</code> object and expects the method
     * to return False.
     */
    @Test
    void addNote_checkRepeatedNoteName_expectFalse() {
        String noteName = "dummyName";
        String topicName = "SORTING";
        Note note = new Note(noteName, noteName + ".txt", topicName);
        TopicManager topicManager = new TopicManager();
        topicManager.addNote(noteName, topicName, note);
        assertFalse(topicManager.addNote(noteName, topicName, note));
    }

    /**
     * Checks the <code>isValidTopic</code> method of the <code>TopicManager</code> class.
     * Inputs a valid topic name and expects the method to return true.
     */
    @Test
    void isValidTopic_checkValidTopic_expectTrue() {
        String validTopic = "SORTING";
        assertTrue(new TopicManager().isValidTopic(validTopic));
    }

    /**
     * Checks the <code>isValidTopic</code> method of the <code>TopicManager</code> class.
     * Inputs a invalid topic name and expects the method to return false.
     */
    @Test
    void isValidTopic_checkInvalidTopic_expectFalse() {
        String invalidTopic = "invalidTopic";
        assertFalse(new TopicManager().isValidTopic(invalidTopic));
    }
}
