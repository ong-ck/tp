package seedu.clialgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        topic.getNotes().put("bubble sort notes", new Note("dummy", "dummy", "SORTING"));
        assertTrue(topicManager.removeNote("bubble sort notes"));
    }

    /**
     * Checks the <code>removeNote</code> method of the <code>TopicManager</code> class.
     * Instantiates a topicManager object.
     * Expects the method to return false since the note does note exist.
     */
    @Test
    void removeNote_checkForNoteThatDoesNotExist_expectFalse() {
        TopicManager topicManager = new TopicManager();
        String noteNameThatDoesNotExist = "dummy";
        assertFalse(topicManager.removeNote(noteNameThatDoesNotExist));
    }

    /**
     * Checks the <code>isRepeatedNote</code> method of the <code>TopicManager</code> class.
     * Inputs a non-existent note name.
     * Expects the method to return false.
     */
    @Test
    void isRepeatedNote_checkForNoteThatDoesNotExist_expectFalse() {
        TopicManager topicManager = new TopicManager();
        String noteName = "thisNoteNameDoesNotExist";
        assertFalse(topicManager.isRepeatedNote(noteName));
    }

    /**
     * Checks the <code>isRepeatedNote</code> method of the <code>TopicManager</code> class.
     * Adds a note, and in the next instance, check if the note was used before.
     * Expects the method to return true.
     */
    @Test
    void isRepeatedNote_checkForNoteThatDoesExist_expectTrue() {
        TopicManager topicManager = new TopicManager();
        String noteName = "queue";
        String topicName = "LINKED_LIST";
        Note note = new Note(noteName, "dummy path", topicName);
        topicManager.addNote(noteName, topicName, note);
        assertTrue(topicManager.isRepeatedNote(noteName));
    }


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

    @Test
    void isValidTopic_validTopicInput_expectTrue() {
        ArrayList<String> validTopics = new ArrayList<>(
                Arrays.asList("SORTING", "LINKED_LIST", "GRAPH_STRUCTURES", "BINARY_HEAP", "HASH_TABLE",
                        "GRAPH_TRAVERSAL", "BINARY_SEARCH_TREE", "SS_SHORTEST_PATH", "UNION_FIND_DS",
                        "MINIMUM_SPANNING_TREE")
        );
        TopicManager topicManager = new TopicManager();
        for (String topic : validTopics) {
            assertTrue(topicManager.isValidTopic(topic));
        }
    }

    @Test
    void isValidTopic_invalidTopicInput_expectFalse() {
        TopicManager topicManager = new TopicManager();
        ArrayList<String> lowerCaseTopics = new ArrayList<>(
                Arrays.asList("sorting", "linked_list", "graph_structures", "binary_heap", "hash_table",
                        "graph_traversal", "binary_search_tree", "ss_shortest_path", "union_find_ds",
                        "minimum_spanning_tree")
        );
        for (String topic : lowerCaseTopics) {
            assertFalse(topicManager.isValidTopic(topic));
        }

        ArrayList<String> capitalizedCaseTopics = new ArrayList<>(
                Arrays.asList("Sorting", "Linked_list", "Graph_structures", "Binary_heap", "Hash_table",
                        "Graph_traversal", "Binary_search_tree", "Ss_shortest_path", "Union_find_ds",
                        "Minimum_spanning_tree")
        );
        for (String topic : capitalizedCaseTopics) {
            assertFalse(topicManager.isValidTopic(topic));
        }

        ArrayList<String> noUnderScoreTopics = new ArrayList<>(
                Arrays.asList("LINKED LIST", "GRAPH STRUCTURES", "BINARY HEAP", "HASH TABLE", "GRAPH TRAVERSAL",
                        "BINARY SEARCH TREE", "SS SHORTEST PATH", "UNION FIND DS", "MINIMUM SPANNING TREE")
        );
        for (String topic : noUnderScoreTopics) {
            assertFalse(topicManager.isValidTopic(topic));
        }
    }

    @Test
    void isEmpty_allNotesIsNotEmpty_expectFalse() {
        TopicManager topicManager = new TopicManager();
        String noteName = "queue";
        String topicName = "LINKED_LIST";
        Note note = new Note(noteName, "dummy path", topicName);
        topicManager.addNote(noteName, topicName, note);
        assertFalse(topicManager.isEmpty());
    }

    @Test
    void isEmpty_allNotesIsEmpty_expectTrue() {
        TopicManager topicManager = new TopicManager();
        assertTrue(topicManager.isEmpty());
    }

    @Test
    void isTopicEmpty_givenTopicIsNotEmpty_expectFalse() {
        TopicManager topicManager = new TopicManager();
        String noteName = "queue";
        String topicName = "LINKED_LIST";
        Note note = new Note(noteName, "dummy path", topicName);
        topicManager.addNote(noteName, topicName, note);
        assertFalse(topicManager.isTopicEmpty(topicName));
    }

    @Test
    void isTopicEmpty_givenTopicIsEmpty_expectTrue() {
        TopicManager topicManager = new TopicManager();
        String topicName = "LINKED_LIST";
        assertTrue(topicManager.isTopicEmpty(topicName));
    }

    @Test
    void getTopics_useGetTopicsMethodOnTopicManager_expectCLIAlgoTopics() {
        TopicManager topicManager = new TopicManager();
        HashMap<String, Topic> actualTopics = topicManager.getTopics();

        HashMap<String, Topic> expectedTopics = new HashMap<>();
        ArrayList<String> topicNames = new ArrayList<>(
                Arrays.asList("SORTING", "LINKED_LIST", "GRAPH_STRUCTURES", "BINARY_HEAP", "HASH_TABLE",
                        "GRAPH_TRAVERSAL", "BINARY_SEARCH_TREE", "SS_SHORTEST_PATH", "UNION_FIND_DS",
                        "MINIMUM_SPANNING_TREE")
        );
        for (String topicName : topicNames) {
            expectedTopics.put(topicName, new Topic(topicName));
        }

        Set<String> actualTopicsNames = actualTopics.keySet();
        Set<String> expectedTopicsNames = expectedTopics.keySet();

        assertEquals(expectedTopicsNames, actualTopicsNames);
    }

    @Test
    void getTopicNames_useGetTopicNamesOnTopicManager_expectCLIAlgoTopicNames() {
        TopicManager topicManager = new TopicManager();
        ArrayList<String> actualTopicsNames = topicManager.getTopicNames();

        ArrayList<String> expectedTopicsNames = new ArrayList<>(
                Arrays.asList("SORTING", "LINKED_LIST", "GRAPH_STRUCTURES", "BINARY_HEAP", "HASH_TABLE",
                        "GRAPH_TRAVERSAL", "BINARY_SEARCH_TREE", "SS_SHORTEST_PATH", "UNION_FIND_DS",
                        "MINIMUM_SPANNING_TREE")
        );
        assertEquals(expectedTopicsNames, actualTopicsNames);
    }

    @Test
    void getAllNotes_inputNotes_expectedInputNotesToBeReturn() {
        TopicManager topicManager = new TopicManager();

        ArrayList<String> expectedResult = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            Note note = new Note("dummy" + index, "dummy", "dummy");
            topicManager.addNote("dummy" + index, "LINKED_LIST", note);
            expectedResult.add("dummy" + index);
        }
        assertEquals(expectedResult, topicManager.getAllNotes());
    }

    @Test
    void getNotesByTopic_inputNotesByTopic_expectCorrectNotesByTopic() {
        TopicManager topicManager = new TopicManager();
        String noteName1 = "queue";
        String topicName1 = "LINKED_LIST";
        Note note1 = new Note(noteName1, "dummy1", topicName1);
        topicManager.addNote(noteName1, topicName1, note1);

        String noteName2 = "deque";
        Note note2 = new Note(noteName2, "dummy2", topicName1);
        topicManager.addNote(noteName2, topicName1, note2);

        String noteName3 = "bubble sort";
        String topicName2 = "SORTING";
        Note note3 = new Note(noteName3, "dummy3", topicName2);
        topicManager.addNote(noteName3, topicName2, note3);

        String noteName4 = "merge sort";
        Note note4 = new Note(noteName4, "dummy4", topicName2);
        topicManager.addNote(noteName4, topicName2, note4);

        ArrayList<String> expectedOutcomeForLinkedList = new ArrayList<>();
        expectedOutcomeForLinkedList.add("deque");
        expectedOutcomeForLinkedList.add("queue");
        assertEquals(expectedOutcomeForLinkedList, topicManager.getNotesByTopic("LINKED_LIST"));

        ArrayList<String> expectedOutcomeForSorting = new ArrayList<>();
        expectedOutcomeForSorting.add("bubble sort");
        expectedOutcomeForSorting.add("merge sort");
        assertEquals(expectedOutcomeForSorting, topicManager.getNotesByTopic("SORTING"));
    }

    @Test
    void initialize_xx() {
        TopicManager topicManager = new TopicManager();

        ArrayList<String> expectedAllNotes = new ArrayList<>();

        String topicName = "LINKED_LIST";

        String noteName1 = "queue";
        Note note1 = new Note(noteName1, "dummy1", topicName);
        topicManager.addNote(noteName1, topicName, note1);

        String noteName2 = "stack";
        Note note2 = new Note(noteName2, "dummy2", topicName);
        topicManager.addNote(noteName2, topicName, note2);

        expectedAllNotes.add(noteName2);
        expectedAllNotes.add(noteName1);

        TopicManager topicManagerTest = new TopicManager();
        topicManagerTest.initialize(topicManager.getTopics());

        assertEquals(expectedAllNotes, topicManager.getAllNotes());
    }
}
