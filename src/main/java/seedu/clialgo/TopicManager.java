package seedu.clialgo;

import seedu.clialgo.file.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The <code>TopicManager</code> object handles the different
 * <code>Topic</code> objects and the notes within them.
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
    private HashSet<String> allFiles;

    /** Data Structure to hold all the topics */
    private HashMap<String, Topic> topics;

    private HashSet<String> allFilesOutsideTestMode;
    private HashMap<String, Topic> topicsOutsideTestMode;
    private boolean isTestModeOn;

    /**
     * Constructor that initializes a <code>TopicManager</code> object that contains a HashMap of all the names of the
     * topics in CLIAlgo as keys, with a corresponding <code>Topic</code> object as value. Also initializes a HashSet
     * that will be used to store the names of all files that will be added.
     */
    public TopicManager() {
        allFiles = new HashSet<>();
        topics = new HashMap<>();
        for (String topicName : TOPIC_NAMES) {
            topics.put(topicName, new Topic(topicName));
        }
        isTestModeOn = false;
    }

    /**
     * Constructor that initialises a <code>TopicManager</code> object that contains a HashSet of the current names of
     * the files present as well as a HashMap of all the topics.
     *
     * @param allFiles A HashSet of the names of all the files present.
     * @param topics A HashMap of all the topics in CLIAlgo.
     */
    public TopicManager(HashSet<String> allFiles, HashMap<String, Topic> topics) {
        this.allFiles = allFiles;
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


    /** Checks if there are any files stored in CLIAlgo. */
    public boolean isEmpty() {
        return allFiles.isEmpty();
    }

    /** Checks if a specified topic has no files stored in it. */
    public boolean isTopicEmpty(String topic) {
        return topics.get(topic).isEmpty();
    }

    /** Checks if a given file name has been used before. */
    public boolean isRepeatedNote(String fileName) {
        return this.allFiles.contains(fileName);
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
     * Gets all files stored in CLIAlgo and stores it in an ArrayList.
     *
     * @return An ArrayList containing all the names of the files stored in CLIAlgo.
     */
    public ArrayList<String> getAllFiles() {
        ArrayList<String> toPrintFiles = new ArrayList<>();
        for (Map.Entry<String, Topic> entry : topics.entrySet()) {
            Topic currentTopic = entry.getValue();
            toPrintFiles.addAll(currentTopic.getAllFilesInTopic());
        }
        return toPrintFiles;
    }

    /**
     * Get a list of all note stored in a specified topic.
     *
     * @param topic The specified topic.
     * @return An ArrayList containing names of all the notes stored in the specified topic.
     */
    public ArrayList<String> getFilesByTopic(String topic) {
        return topics.get(topic).getAllFilesInTopic();
    }

    /**
     * Get a list of all topics stored in CLIAlgo that are grouped by topics.
     *
     * @return An HashMap containing all notes stored in CLIAlgo.
     */
    public HashMap<String, ArrayList<String>> getAllFilesInTopic() {
        HashMap<String, ArrayList<String>> toPrintFiles = new HashMap<>();
        for (Map.Entry<String, Topic> entry : topics.entrySet()) {
            Topic currentTopic = entry.getValue();
            if (currentTopic.isEmpty()) {
                continue;
            }
            toPrintFiles.put(entry.getKey(), currentTopic.getAllFilesInTopic());
            assert toPrintFiles.containsKey(currentTopic.getTopicName());
        }
        return toPrintFiles;
    }

    /**
     * Adds a new file into the specific <code>Topic</code> object
     * while keeping track of the names of all files added.
     * Name of the note to be added cannot be the same as a previously added file.
     *
     * @param fileName Name of the file.
     * @param topicName Name of the topic the note is added to.
     * @param file The <code>Note</code> object representing the file.
     * @return True if file is successfully added and False otherwise.
     */
    public boolean addFile(String fileName, String topicName, File file) {
        // Check if note name has been taken
        if (allFiles.contains(fileName)) {
            return false;
        }

        // Adds note into topic hashmap
        topics.get(topicName).addFile(fileName, file);

        assert topics.get(topicName).isInsideTopic(fileName);

        // Keep track of name of file added
        allFiles.add(fileName);

        return true;
    }

    /**
     * Removes a file from the specific <code>Topic</code> object while keeping track of the names of all files
     * remaining.
     *
     * @param fileName Name of the file.
     * @return Returns true if the name of the file is inside any topic, false otherwise
     */
    public boolean removeFile(String fileName) {
        for (String topicName : TOPIC_NAMES) {

            // Check which topic contains that particular file
            if ((topics.get(topicName).isInsideTopic(fileName))) {
                // Remove name of file from the allFiles set to keep track of names
                allFiles.remove(fileName);

                assert !allFiles.contains(fileName);

                // Remove the file from that particular topic
                return topics.get(topicName).removeFile(fileName);
            }
        }
        return false;
    }

    /**
     * Initializes the <code>topics</code> and <code>allFile</code> of this object by taking in input from the
     * <code>FileManager</code> object.
     *
     * @param topics The output obtained from the <code>FileManager</code> by calling <code>decodeAll</code>.
     */
    public void initialize(HashMap<String, Topic> topics) {
        this.topics = topics;
        for (Topic topic: topics.values()) {
            if (topic != null) {
                allFiles.addAll(topic.getAllFilesInTopic());
            }
        }
    }

    /**
     * Resets <code>topics</code> and <code>allNotes</code> when test mode starts. Stores the data outside of test mode
     * separately.
     */
    public void testModeStart() {
        this.topicsOutsideTestMode = topics;
        this.allFilesOutsideTestMode = allFiles;
        allFiles = new HashSet<>();
        topics = new HashMap<>();
        for (String topicName : TOPIC_NAMES) {
            topics.put(topicName, new Topic(topicName));
        }
        this.isTestModeOn = true;
    }

    /**
     * Retrieves the <code>topics</code> and <code>allFiles</code> data from before the start of test mode when test
     * mode ends such that the state before the start of test mode is restored.
     */
    public void testModeEnd() {
        this.allFiles = allFilesOutsideTestMode;
        this.topics = topicsOutsideTestMode;
        this.isTestModeOn = false;
    }

    /**
     * Get a list of all topics stored in CLIAlgo that are before a specific target topic.
     *
     * @param noteName The name of the note that is part of the target topic.
     * @return A HashMap containing all notes before a specific target topic.
     */
    public LinkedHashMap<String, ArrayList<String>> getAllNotesBeforeTopic(String noteName) {
        LinkedHashMap<String, ArrayList<String>> toPrintNotes = new LinkedHashMap<>();
        boolean isPartOfTopoOrder = false;

        for (String topicName : TOPIC_ORDER) {
            // Check which topic contains that particular note
            if ((topics.get(topicName).isInsideTopic(noteName))) {
                isPartOfTopoOrder = true;
            }

            // Start tracking subsequent notes when topic of target note is found
            if (isPartOfTopoOrder) {
                ArrayList<String> topicNotes = getFilesByTopic(topicName);
                toPrintNotes.put(topicName, topicNotes);
            }
        }
        return toPrintNotes;
    }
}
