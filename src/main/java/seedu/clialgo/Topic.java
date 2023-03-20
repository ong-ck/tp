package seedu.clialgo;

import seedu.clialgo.file.Note;
import seedu.clialgo.file.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map;


/**
 * The <code>Topic</code> object handles the operations of the notes within a specific topic.
 */
public class Topic {
    private final String topicName;
    private final HashMap<String, File> files;

    /**
     * Constructor that initializes an empty <code>Topic</code> object.
     *
     * @param topicName The name of the topic.
     */
    public Topic(String topicName) {
        this.topicName = topicName;
        files = new HashMap<>();
    }

    /**
     * Constructor that initializes a <code>Topic</code> object with files stored in it.
     *
     * @param topicName The name of the topic.
     * @param files A HashMap containing the files stored in the <code>Topic</code> object.
     */
    public Topic(String topicName, HashMap<String, File> files) {
        this.topicName = topicName;
        this.files = files;
    }

    /**
     * Checks if the <code>Topic</code> object has any files inside.
     *
     * @return Returns true if the topic has no files inside, false otherwise.
     */
    public boolean isEmpty() {
        return this.files.isEmpty();
    }

    /**
     * Checks if the <code>Topic</code> object has a specified file inside.
     *
     * @param fileName Name of file.
     * @return Returns true if the topic contains the file that is specified by fileName, false otherwise.
     */
    public boolean isInsideTopic(String fileName) {
        return this.files.containsKey(fileName);
    }

    /**
     * Obtains all the files inside the <code>Topic</code> object.
     *
     * @return A HashMap of all the files inside this <code>Topic</code> object.
     */
    public HashMap<String, File> getFiles() {
        return files;
    }

    public String getTopicName() {
        return this.topicName;
    }

    /**
     * Gets all files stored in this specific topic and stores them in an ArrayList.
     *
     * @return An ArrayList containing all the files stored in this topic.
     */
    public ArrayList<String> getAllFilesInTopic() {
        ArrayList<String> topicFiles = new ArrayList<>();
        for (Map.Entry<String, File> entry : files.entrySet()) {
            String fileName = entry.getValue().getName();
            topicFiles.add(fileName);
        }
        return topicFiles;
    }

    /**
     * Adds a file linked to a specific topic.
     *
     * @param name Name of the file.
     * @param file A <code>Note</code> object representing the file.
     */
    public void addFile(String name, File file) {
        files.put(name, file);
    }

    /**
     * Removes a file based on its name.
     *
     * @param name Name of the file.
     */
    public boolean removeFile(String name) {
        files.remove(name);
        return true;
    }

    /**
     * A method that checks for equality of <code>Topic</code> objects.
     *
     * @param otherTopic The other <code>Topic</code> object to be checked against.
     * @return A boolean value to determine whether the <code>Topic</code> objects are equal.
     */
    public boolean equals(Topic otherTopic) {
        return Objects.equals(this.topicName, otherTopic.topicName) &&
                Objects.equals(this.files, otherTopic.files);
    }
}
