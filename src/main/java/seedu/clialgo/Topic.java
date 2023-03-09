package seedu.clialgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map;

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

    public Topic(String topicName, HashMap<String, Note> notes) {
        this.topicName = topicName;
        this.notes = notes;
    }

    public HashMap<String, Note> getNotes() {
        return notes;
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

    /** Checks if the topic have not notes inside */
    public boolean isEmpty() {
        return this.notes.isEmpty();
    }

    // Placeholder method
    public void removeNote(String name) {

    }

    /**
     * Gets all notes stored in this specific topic and stores them in an ArrayList.
     *
     * @return An ArrayList containing all the notes stored in this topic.
     */
    public ArrayList<String> getAllNotesInTopic() {
        ArrayList<String> topicNotes = new ArrayList<>();
        for (Map.Entry<String, Note> entry : notes.entrySet()) {
            String noteName = entry.getValue().getName();
            topicNotes.add(noteName);
        }
        return topicNotes;
    }

    /**
     * A method that checks for equality of <code>Topic</code> objects.
     *
     * @param otherTopic The other <code>Topic</code> object to be checked against.
     * @return A boolean value to determine whether the <code>Topic</code> objects are equal.
     */
    public boolean equals(Topic otherTopic) {
        return Objects.equals(this.topicName, otherTopic.topicName) &&
                Objects.equals(this.notes, otherTopic.notes);
    }
}
