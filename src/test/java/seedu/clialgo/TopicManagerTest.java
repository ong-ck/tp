package seedu.clialgo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopicManagerTest {
    /**
     * Checks the <code>removeNote</code> method of the <code>TopicManager</code> class.
     * Instantiates a topicManager object which contains a topic object which contains a test note.
     * Expects the method to return true if the test note is removed successfully.
     */
    @Test
    void removeNote_checkForNoteThatExist_expectTrue() {
        TopicManager topicManager = new TopicManager();
        Topic topic = new Topic("SORTING");
        topicManager.getTopics().put("SORTING", topic);
        topic.notes.put("bubble sort notes", new Note("dummy", "dummy", "SORTING"));
        assertTrue(topicManager.removeNote("bubble sort notes"));
    }

    /**
     * Checks the <code>noteExist</code> method of the <code>TopicManager</code> class.
     * Inputs a non-existent note name.
     * Expects the method to return false.
     */
    @Test
    void noteExist_checkForNoteThatDoesNotExist_expectFalse() {
        String noteName = "thisNoteNameDoesNotExist";
        assertFalse(new TopicManager().noteExist(noteName));
    }
}

