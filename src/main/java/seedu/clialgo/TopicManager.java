package seedu.clialgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TopicManager {
    /**
     * List of valid topics
     */
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

    public HashMap<String, Topic> getTopics() {
        return this.topics;
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

    /**
     * Removes a note from the specific <code>Topic</code> object
     * while keeping track of the names of all notes remaining.
     * Name of the note to be removed must be currently in the <code>Topic</code> object .
     * @param noteName Name of the note file
     */
    public boolean removeNote(String noteName) {
        for (String topicName : TOPIC_NAMES) {

            // check which topic contains that particular note
            if ((topics.get(topicName).notes).containsKey(noteName)) {

                // remove name of note from the allNotes set to keep track of names
                allNotes.remove(noteName);

                // remove the note from that particular topic
                return topics.get(topicName).removeNote(noteName);
            }
        }
        return false;
    }

    /**
     * Checks if the name of a note exists.
     * @param noteName Name of the note file
     * @return Returns true if name of note file exists, false if otherwise.
     */
    public boolean noteExist (String noteName) {
        for (String topicName : TOPIC_NAMES) {
            return (topics.get(topicName).notes).containsKey(noteName);
        }
        return false;
    }
}
