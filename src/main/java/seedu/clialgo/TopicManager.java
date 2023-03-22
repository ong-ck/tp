package seedu.clialgo;

import seedu.clialgo.file.CS2040CFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The <code>TopicManager</code> object handles the different
 * <code>Topic</code> objects and the CS2040CFiles within them.
 */
public class TopicManager {
    /** List of valid topics */
    private static final ArrayList<String> TOPIC_NAMES = new ArrayList<>(
            Arrays.asList("SORTING", "LINKED_LIST", "GRAPH_STRUCTURES", "BINARY_HEAP", "HASH_TABLE", "GRAPH_TRAVERSAL",
                    "BINARY_SEARCH_TREE", "SS_SHORTEST_PATH", "UNION_FIND_DS", "MINIMUM_SPANNING_TREE")
    );

    /** List of topics in topological order */
    private static final ArrayList<String> TOPIC_ORDER = new ArrayList<>(
            Arrays.asList("MINIMUM_SPANNING_TREE", "SS_SHORTEST_PATH", "GRAPH_TRAVERSAL", "GRAPH_STRUCTURES",
                    "BINARY_SEARCH_TREE", "UNION_FIND_DS", "HASH_TABLE", "BINARY_HEAP", "LINKED_LIST", "SORTING")
    );

    /** General HashSet to check for duplicate names. */
    private HashSet<String> allCS2040CFiles;

    /** Data Structure to hold all the topics */
    private HashMap<String, Topic> topics;

    private HashSet<String> allCS2040CFilesOutsideTestMode;
    private HashMap<String, Topic> topicsOutsideTestMode;
    private boolean isTestModeOn;

    /**
     * Constructor that initializes a <code>TopicManager</code> object that contains a HashMap of all the names of the
     * topics in CLIAlgo as keys, with a corresponding <code>Topic</code> object as value. Also initializes a HashSet
     * that will be used to store the names of all CS2040CFiles that will be added.
     */
    public TopicManager() {
        allCS2040CFiles = new HashSet<>();
        topics = new HashMap<>();
        for (String topicName : TOPIC_NAMES) {
            topics.put(topicName, new Topic(topicName));
        }
        isTestModeOn = false;
    }

    /**
     * Constructor that initialises a <code>TopicManager</code> object that contains a HashSet of the current names of
     * the CS2040CFiles present as well as a HashMap of all the topics.
     *
     * @param allCS2040CFiles A HashSet of the names of all the CS2040CFiles present.
     * @param topics A HashMap of all the topics in CLIAlgo.
     */
    public TopicManager(HashSet<String> allCS2040CFiles, HashMap<String, Topic> topics) {
        this.allCS2040CFiles = allCS2040CFiles;
        this.topics = topics;
    }

    /**
     * Checks if test mode is turned on.
     *
     * @return True if test mode is turned on, false otherwise.
     */
    public boolean getIsTestModeOn() {
        return this.isTestModeOn;
    }


    /** Checks if there are any CS2040CFiles stored in CLIAlgo. */
    public boolean isEmpty() {
        return allCS2040CFiles.isEmpty();
    }

    /** Checks if a specified topic has no CS2040CFiles stored in it. */
    public boolean isTopicEmpty(String topic) {
        return topics.get(topic).isEmpty();
    }

    /** Checks if a given CS2040CFile name has been used before. */
    public boolean isRepeatedCS2040CFile(String cs2040CFileName) {
        return this.allCS2040CFiles.contains(cs2040CFileName);
    }

    /**
     * Checks if the input string is a valid topic.
     *
     * @param topic The input string.
     * @return True if the input string is a valid topic, false otherwise.
     */
    public boolean isValidTopic(String topic) {
        return TOPIC_NAMES.contains(topic);
    }

    /**
     * Obtains all the topics in CLIAlgo.
     *
     * @return A HashMap containing all the topics in CLIAlgo.
     */
    public HashMap<String, Topic> getTopics() {
        return this.topics;
    }

    /**
     * Obtains all the names of the topics in CLIAlgo.
     *
     * @return An ArrayList containing all the names of the topics in CLIAlgo.
     */
    public ArrayList<String> getTopicNames() {
        return TOPIC_NAMES;
    }

    /**
     * Gets all CS2040CFiles stored in CLIAlgo and stores it in an ArrayList.
     *
     * @return An ArrayList containing all the names of the CS2040CFiles stored in CLIAlgo.
     */
    public ArrayList<String> getAllCS2040CFiles() {
        ArrayList<String> toPrintCS2040CFiles = new ArrayList<>();
        for (Map.Entry<String, Topic> entry : topics.entrySet()) {
            Topic currentTopic = entry.getValue();
            toPrintCS2040CFiles.addAll(currentTopic.getAllCS2040CFilesInTopic());
        }
        return toPrintCS2040CFiles;
    }

    /**
     * Get a list of all CS2040CFiles stored in a specified topic.
     *
     * @param topic The specified topic.
     * @return An ArrayList containing names of all the CS2040CFiles stored in the specified topic.
     */
    public ArrayList<String> getCS2040CFilesByTopic(String topic) {
        return topics.get(topic).getAllCS2040CFilesInTopic();
    }

    /**
     * Get a list of all topics stored in CLIAlgo that are grouped by topics.
     *
     * @return An HashMap containing all CS2040CFiles stored in CLIAlgo.
     */
    public HashMap<String, ArrayList<String>> getAllCS2040CFilesByTopic() {
        HashMap<String, ArrayList<String>> toPrintCS2040CFiles = new HashMap<>();
        for (Map.Entry<String, Topic> entry : topics.entrySet()) {
            Topic currentTopic = entry.getValue();
            if (currentTopic.isEmpty()) {
                continue;
            }
            toPrintCS2040CFiles.put(entry.getKey(), currentTopic.getAllCS2040CFilesInTopic());
            assert toPrintCS2040CFiles.containsKey(currentTopic.getTopicName());
        }
        return toPrintCS2040CFiles;
    }

    /**
     * Adds a new CS2040CFile into the specific <code>Topic</code> object
     * while keeping track of the names of all CS2040CFiles added.
     * Name of the CS2040CFile to be added cannot be the same as a previously added CS2040CFile.
     *
     * @param cs2040cFileName Name of the CS2040CFile.
     * @param topicName Name of the topic the CS2040CFile is added to.
     * @param cs2040cFile The <code>CS2040CFile</code> object representing the CS2040CFile.
     * @return True if file is successfully added and False otherwise.
     */
    public boolean addCS2040CFile(String cs2040cFileName, String topicName, CS2040CFile cs2040cFile) {
        // Check if CS2040CFile name has been taken
        if (allCS2040CFiles.contains(cs2040cFileName)) {
            return false;
        }

        // Adds CS2040CFile into topic hashmap
        topics.get(topicName).addCS2040CFile(cs2040cFileName, cs2040cFile);

        assert topics.get(topicName).isInsideTopic(cs2040cFileName);

        // Keep track of name of CS2040CFile added
        allCS2040CFiles.add(cs2040cFileName);

        return true;
    }

    /**
     * Removes a CS2040CFile from the specific <code>Topic</code> object while keeping track of the names of all
     * CS2040CFiles remaining.
     *
     * @param cs2040cFileName Name of the CS2040CFile.
     * @return Returns true if the name of the CS2040CFile is inside any topic, false otherwise
     */
    public boolean removeCS2040CFile(String cs2040cFileName) {
        for (String topicName : TOPIC_NAMES) {

            // Check which topic contains that particular file
            if ((topics.get(topicName).isInsideTopic(cs2040cFileName))) {
                // Remove name of file from the allFiles set to keep track of names
                allCS2040CFiles.remove(cs2040cFileName);

                assert !allCS2040CFiles.contains(cs2040cFileName);

                // Remove the file from that particular topic
                return topics.get(topicName).removeCS2040CFile(cs2040cFileName);
            }
        }
        return false;
    }

    /**
     * Initializes the <code>topics</code> and <code>allCS2040CFile</code> of this object by taking in input from the
     * <code>FileManager</code> object.
     *
     * @param topics The output obtained from the <code>FileManager</code> by calling <code>decodeAll</code>.
     */
    public void initialize(HashMap<String, Topic> topics) {
        this.topics = topics;
        for (Topic topic: topics.values()) {
            if (topic != null) {
                allCS2040CFiles.addAll(topic.getAllCS2040CFilesInTopic());
            }
        }
    }

    /**
     * Resets <code>topics</code> and <code>allCS2040CFiles</code> when test mode starts. Stores the data outside of
     * test mode separately.
     */
    public void testModeStart() {
        this.topicsOutsideTestMode = topics;
        this.allCS2040CFilesOutsideTestMode = allCS2040CFiles;
        allCS2040CFiles = new HashSet<>();
        topics = new HashMap<>();
        for (String topicName : TOPIC_NAMES) {
            topics.put(topicName, new Topic(topicName));
        }
        this.isTestModeOn = true;
    }

    /**
     * Retrieves the <code>topics</code> and <code>allCS2040CFiles</code> data from before the start of test mode when
     * test mode ends such that the state before the start of test mode is restored.
     */
    public void testModeEnd() {
        this.allCS2040CFiles = allCS2040CFilesOutsideTestMode;
        this.topics = topicsOutsideTestMode;
        this.isTestModeOn = false;
    }

    /**
     * Get a list of all topics stored in CLIAlgo that are before a specific target topic.
     *
     * @param cs2040cFileName The name of the CS2040CFile that is part of the target topic.
     * @return A HashMap containing all cs2040cFiles before a specific target topic.
     */
    public LinkedHashMap<String, ArrayList<String>> getAllCS2040CFilesBeforeTopic(String cs2040cFileName) {
        LinkedHashMap<String, ArrayList<String>> toPrintCS2040CFiles = new LinkedHashMap<>();
        boolean isPartOfTopoOrder = false;

        for (String topicName : TOPIC_ORDER) {
            // Check which topic contains that particular CS2040CFile
            if ((topics.get(topicName).isInsideTopic(cs2040cFileName))) {
                isPartOfTopoOrder = true;
            }

            // Start tracking subsequent CS2040CFiles when topic of target CS2040CFile is found
            if (isPartOfTopoOrder) {
                ArrayList<String> topicCS2040CFiles = getCS2040CFilesByTopic(topicName);
                toPrintCS2040CFiles.put(topicName, topicCS2040CFiles);
            }
        }
        return toPrintCS2040CFiles;
    }
}
