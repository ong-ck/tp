package seedu.clialgo;

import java.util.HashMap;

// Placeholder class
public class Topic {
    private String topicName;
    private HashMap<String, Note> notes;

    public Topic(String topicName) {
        this.topicName = topicName;
        notes = new HashMap<>();
    }

    public boolean addNote(String name, String path) {
        return true;
    }

    // Placeholder method
    public void removeNote(String name) {

    }

    public void printSortedOrder() {

    }
}
