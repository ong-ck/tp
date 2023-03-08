package seedu.clialgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The <code>TopicManager</code> object handles the
 */
public class TopicManager {
    /** List of valid topics */
    private static final ArrayList<String> TOPIC_NAMES = new ArrayList<String>(
            Arrays.asList("SORTING", "LINKED_LIST", "GRAPH_STRUCTURES", "BINARY_HEAP", "HASH_TABLE", "GRAPH_TRAVERSAL",
                    "BINARY_SEARCH_TREE", "SS_SHORTEST_PATH", "UNION_FIND_DS", "MINIMUM_SPANNING_TREE")
    );

    // General HashSet to check for duplicate names.
    private HashSet<String> allNotes;

    // Data Structure to hold all the topics
    private HashMap<String, Topic> topics;

    public TopicManager() {
        allNotes = new HashSet<>();
        topics = new HashMap<>();
        for (String topicName : TOPIC_NAMES) {
            topics.put(topicName, new Topic(topicName));
        }
    }

    /**
     * Adds a new note into the specific <code>Topic</code> object
     * while keeping track of the names of all notes added.
     * Name of the note to be added cannot be the same as a previously added note.
     *
     * @param noteName Name of the note file.
     * @param topicName Name of the topic the note is added to.
     * @param note The <code>Note</code> object representing the note file.
     * @return True if note is successfully added and False otherwise.
     */
    public boolean addNote(String noteName, String topicName, Note note) {
        // Check if note name has been taken
        if (allNotes.contains(noteName)) {
            return false;
        }

        // Adds note into topic hashmap
        topics.get(topicName).addNote(noteName, note);

        // Keep track of name of note added
        allNotes.add(noteName);

        return true;
    }

    /**
     * Checks if the input string is a valid topic.
     *
     * @param topic The input string.
     * @return True if the input string is a valid topic, False otherwise.
     */
    public boolean isValidTopic(String topic) {
        return TOPIC_NAMES.contains(topic);
    }
}
