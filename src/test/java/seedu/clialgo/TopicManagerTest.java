package seedu.clialgo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TopicManagerTest {
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
}
