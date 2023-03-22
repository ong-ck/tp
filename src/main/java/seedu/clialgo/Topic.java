package seedu.clialgo;

<<<<<<< HEAD
import seedu.clialgo.file.Code;
import seedu.clialgo.file.Note;
=======
import seedu.clialgo.file.CS2040CFile;
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map;


/**
 * The <code>Topic</code> object handles the operations of the CS2040CFiles within a specific topic.
 */
public class Topic {
    private final String topicName;
<<<<<<< HEAD
    private final HashMap<String, Note> notes;
    private final HashMap<String, Code> codes;
=======
    private final HashMap<String, CS2040CFile> cs2040cFiles;
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c

    /**
     * Constructor that initializes an empty <code>Topic</code> object.
     *
     * @param topicName The name of the topic.
     */
    public Topic(String topicName) {
        this.topicName = topicName;
<<<<<<< HEAD
        notes = new HashMap<>();
        codes = new HashMap<>();
=======
        cs2040cFiles = new HashMap<>();
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
    }

    /**
     * Constructor that initializes a <code>Topic</code> object with CS2040CFiles stored in it.
     *
     * @param topicName The name of the topic.
     * @param cs2040cFiles A HashMap containing the CS2040CFiles stored in the <code>Topic</code> object.
     */
<<<<<<< HEAD
    public Topic(String topicName, HashMap<String, Note> notes, HashMap<String, Code> codes) {
        this.topicName = topicName;
        this.notes = notes;
        this.codes = codes;
=======
    public Topic(String topicName, HashMap<String, CS2040CFile> cs2040cFiles) {
        this.topicName = topicName;
        this.cs2040cFiles = cs2040cFiles;
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
    }

    /**
     * Checks if the <code>Topic</code> object has any CS2040CFiles inside.
     *
     * @return Returns true if the topic has no CS2040CFiles inside, false otherwise.
     */
    public boolean isEmpty() {
        return this.cs2040cFiles.isEmpty();
    }

    /**
     * Checks if the <code>Topic</code> object has a specified CS2040CFile inside.
     *
     * @param cs2040CFileName Name of CS2040CFile.
     * @return Returns true if the topic contains the CS2040CFile that is specified by cs2040CFileName, false otherwise.
     */
    public boolean isInsideTopic(String cs2040CFileName) {
        return this.cs2040cFiles.containsKey(cs2040CFileName);
    }

    /**
     * Obtains all the CS2040CFiles inside the <code>Topic</code> object.
     *
     * @return A HashMap of all the cs2040CFiles inside this <code>Topic</code> object.
     */
    public HashMap<String, CS2040CFile> getC2040CFiles() {
        return cs2040cFiles;
    }

    public String getTopicName() {
        return this.topicName;
    }

    /**
     * Gets all CS2040CFiles stored in this specific topic and stores them in an ArrayList.
     *
     * @return An ArrayList containing all the CS2040CFiles stored in this topic.
     */
    public ArrayList<String> getAllCS2040CFilesInTopic() {
        ArrayList<String> topicCS2040CFiles = new ArrayList<>();
        for (Map.Entry<String, CS2040CFile> entry : cs2040cFiles.entrySet()) {
            String cs2040cFileName = entry.getValue().getName();
            topicCS2040CFiles.add(cs2040cFileName);
        }
        return topicCS2040CFiles;
    }

    /**
     * Adds a CS2040CFile linked to a specific topic.
     *
     * @param name Name of the CS2040CFile.
     * @param cs2040cFile A <code>CS2040CFile</code> object representing the CS2040CFile.
     */
    public void addCS2040CFile(String name, CS2040CFile cs2040cFile) {
        cs2040cFiles.put(name, cs2040cFile);
    }

    /**
     * Removes a CS2040CFile based on its name.
     *
     * @param name Name of the CS2040CFile.
     */
    public boolean removeCS2040CFile(String name) {
        cs2040cFiles.remove(name);
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
                Objects.equals(this.cs2040cFiles, otherTopic.cs2040cFiles);
    }
}
