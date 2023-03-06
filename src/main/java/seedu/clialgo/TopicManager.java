package seedu.clialgo;

import java.util.ArrayList;
import java.util.Arrays;

public class TopicManager {
    /** List of valid topics */
    private static final ArrayList<String> TOPICS = new ArrayList<String>(
            Arrays.asList("SORTING", "LINKED_LIST", "GRAPH_STRUCTURES", "BINARY_HEAP", "HASH_TABLE", "GRAPH_TRAVERSAL",
                    "BINARY_SEARCH_TREE", "SS_SHORTEST_PATH", "UNION_FIND_DS", "MINIMUM_SPANNING_TREE")
    );

    /**
     * Checks if the input string is a valid topic.
     *
     * @param topic The input string.
     * @return True if the input string is a valid topic, False otherwise.
     */
    public boolean isValidTopic(String topic) {
        return TOPICS.contains(topic);
    }
}
