package seedu.clialgo;

import java.util.HashMap;

/**
 * The <code>Topic</code> object handles the operations of the notes within a specific topic.
 */
public class Topic {
    private String topicName;
    private HashMap<String, Note> notes;

    /**
     * Constructor for <code>Topic</code> object.
     *
     * @param topicName The name of the topic.
     */
    public Topic(String topicName) {
        this.topicName = topicName;
        notes = new HashMap<>();
    }

    /**
     * Adds a note linked to a specific topic.
     *
     * @param name Name of the note file.
     * @param note A <code>Note</code> object representing the note file.
     */
    public void addNote(String name, Note note) {
        notes.put(name, note);
    }

    // Placeholder method
    public void removeNote(String name) {

    }

    public void printSortedOrder() {

    }
}
