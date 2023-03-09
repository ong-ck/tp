package seedu.clialgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Placeholder class
public class Topic {
    private String topicName;
    private HashMap<String, Note> notes;

    public Topic(String topicName) {
        this.topicName = topicName;
        notes = new HashMap<>();
    }

    public Topic(String topicName, HashMap<String, Note> notes) {
        this.topicName = topicName;
        this.notes = notes;
    }

    /** Checks if the topic have not notes inside */
    public boolean isEmpty() {
        return this.notes.isEmpty();
    }

    public boolean addNote(String name, String path) {
        return true;
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
}
