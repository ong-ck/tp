package seedu.clialgo;

import org.junit.jupiter.api.Test;
import seedu.clialgo.file.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopicTest {

    /**
     * Checks the <code>equals</code> method of the <code>Topic</code> class.
     * Inputs two equal <code>Topic</code> objects and expects the method to return true.
     */
    @Test
    void equals_checkEqualTopic_expectTrue() {
        String firstTopicName = "LINKED_LIST";
        String secondTopicName = "LINKED_LIST";
        Topic firstTopic = new Topic(firstTopicName);
        Topic secondTopic = new Topic(secondTopicName);
        assertTrue(firstTopic.equals(secondTopic));
    }

    /**
     * Checks the <code>equals</code> method of the <code>Topic</code> class.
     * Inputs two unequal <code>Topic</code> objects and expects the method to return false.
     */
    @Test
    void equals_checkUnequalTopic_expectFalse() {
        String firstTopicName = "LINKED_LIST";
        String secondTopicName = "SORTING";
        Topic firstTopic = new Topic(firstTopicName);
        Topic secondTopic = new Topic(secondTopicName);
        assertFalse(firstTopic.equals(secondTopic));
    }

    /**
     * Checks the <code>addNote</code> method correctly
     * adds a <code>Note</code> object into its Hashmap.
     */
    @Test
    void addNote_checkNoteIsAdded_expectCorrectNotesHashmapAttribute() {
        String testTopicName = "SORTING";
        String testNoteName = "dummyName";

        Note testNote = new Note(testNoteName, testNoteName + ".txt", testTopicName);

        HashMap<String, Note> testNotesHashmap = new HashMap<>();
        testNotesHashmap.put(testNoteName, testNote);

        Topic testTopic = new Topic(testTopicName);
        testTopic.addNote(testNoteName, testNote);

        assertEquals(testTopic.getFiles(), testNotesHashmap);
    }

    @Test
    void isEmpty_topicIsEmpty_expectTrue() {
        Topic topic = new Topic("LINKED_LIST");
        assertTrue(topic.isEmpty());
    }

    @Test
    void isEmpty_topicIsNotEmpty_expectFalse() {
        Topic topic = new Topic("LINKED_LIST");
        String noteName = "queue";
        String topicName = "LINKED_LIST";
        String path = "dummy";
        Note note = new Note(noteName, path, topicName);
        topic.getFiles().put(noteName, note);
        assertFalse(topic.isEmpty());
    }

    @Test
    void isInsideTopic_noteIsInsideTopic_expectTrue() {
        Topic topic = new Topic("LINKED_LIST");
        String noteName = "queue";
        String topicName = "LINKED_LIST";
        String path = "dummy";
        Note note = new Note(noteName, path, topicName);
        topic.getFiles().put(noteName, note);
        assertTrue(topic.isInsideTopic(noteName));
    }

    @Test
    void isInsideTopic_noteIsNotInsideTopic_expectFalse() {
        Topic topic = new Topic("LINKED_LIST");
        String noteNameThatIsNotInside = "dummy";
        assertFalse(topic.isInsideTopic(noteNameThatIsNotInside));
    }

    @Test
    void getNotes_addNotes_expectAddedNotesToBeReturnInHashMap() {
        Topic topic = new Topic("LINKED_LIST");
        String noteName1 = "queue";
        String noteName2 = "deque";
        String path1 = "dummy1";
        String path2 = "dummy2";
        String topicName = "LINKED_LIST";
        Note note1 = new Note(noteName1, path1, topicName);
        Note note2 = new Note(noteName2, path2, topicName);
        topic.getFiles().put(noteName1, note1);
        topic.getFiles().put(noteName2, note2);

        HashMap<String, Note> expectedOutcome = new HashMap<>();
        expectedOutcome.put(noteName1, note1);
        expectedOutcome.put(noteName2, note2);

        assertEquals(expectedOutcome, topic.getFiles());
    }

    @Test
    void getTopicName_inputTopicName_expectCorrectTopicName() {
        Topic topic = new Topic("LINKED_LIST");
        String topicName = "LINKED_LIST";
        assertEquals(topicName, topic.getTopicName());
    }

    @Test
    void getAllNotesInTopic_addNotes_expectAddedNotesToBeReturnInArrayList() {
        String topicName = "LINKED_LIST";
        Topic topic = new Topic(topicName);
        String noteName1 = "queue";
        String noteName2 = "deque";
        String noteName3 = "stack";
        String noteName4 = "dll";
        String path1 = "dummy1";
        String path2 = "dummy2";
        String path3 = "dummy3";
        String path4 = "dummy4";
        Note note1 = new Note(noteName1, path1, topicName);
        Note note2 = new Note(noteName2, path2, topicName);
        Note note3 = new Note(noteName3, path3, topicName);
        Note note4 = new Note(noteName4, path4, topicName);
        topic.getFiles().put(noteName1, note1);
        topic.getFiles().put(noteName2, note2);
        topic.getFiles().put(noteName3, note3);
        topic.getFiles().put(noteName4, note4);

        ArrayList<String> expectedOutcome = new ArrayList<>(Arrays.asList(noteName2, noteName3, noteName4, noteName1));

        assertEquals(expectedOutcome, topic.getAllFilesInTopic());
    }

    @Test
    void removeNote_inputValidNoteName_expectTrue() {
        String topicName = "LINKED_LIST";
        Topic topic = new Topic(topicName);
        String noteName1 = "queue";
        String noteName2 = "deque";
        String noteName3 = "stack";
        String path1 = "dummy1";
        String path2 = "dummy2";
        String path3 = "dummy3";
        Note note1 = new Note(noteName1, path1, topicName);
        Note note2 = new Note(noteName2, path2, topicName);
        Note note3 = new Note(noteName3, path3, topicName);
        topic.getFiles().put(noteName1, note1);
        topic.getFiles().put(noteName2, note2);
        topic.getFiles().put(noteName3, note3);
        assertTrue(topic.removeFile(noteName1));
        assertTrue(topic.removeFile(noteName2));
        assertTrue(topic.removeFile(noteName3));
    }
}
