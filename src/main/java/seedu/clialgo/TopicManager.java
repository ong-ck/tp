package seedu.clialgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TopicManager {
    /** List of valid topics */
    private static final ArrayList<String> TOPIC_NAMES = new ArrayList<>(
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
     * Checks if the input string is a valid topic.
     *
     * @param topic The input string.
     * @return True if the input string is a valid topic, False otherwise.
     */
    public boolean isValidTopic(String topic) {
        return TOPIC_NAMES.contains(topic);
    }

    public boolean isEmpty() {
        return allNotes.isEmpty();
    }
    /**
     * Gets all notes stored in CLIAlgo and stores it in an ArrayList.
     *
     * @return An ArrayList containing all the names of the notes stored in CLIAlgo.
     */
    public ArrayList<String> getAllNotes() {
        ArrayList<String> toPrintNotes = new ArrayList<>();
        for (Map.Entry<String, Topic> entry : topics.entrySet()) {
            Topic currentTopic = entry.getValue();
            toPrintNotes.addAll(currentTopic.getAllNotesInTopic());
        }
        return toPrintNotes;
    }

    public HashMap<String, ArrayList<String>> getNotesByTopic(String topic) {
        HashMap<String, ArrayList<String>> toPrintNotes = new HashMap<>();
        for (Map.Entry<String, Topic> entry : topics.entrySet()) {
            Topic currentTopic = entry.getValue();
            if (currentTopic.isEmpty()) {
                continue;
            }
            toPrintNotes.put(entry.getKey(), currentTopic.getAllNotesInTopic());
        }
        return toPrintNotes;
    }
}
