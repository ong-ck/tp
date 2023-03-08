package seedu.clialgo;

import java.util.HashMap;

// Placeholder class
public class Topic {

    public HashMap<String, Note> notes;
    private String topicName;

    public Topic(String topicName) {
        this.topicName = topicName;
        notes = new HashMap<>();
    }

    public boolean addNote(String name, String path) {
        return true;
    }

    /**
     * Removes a note based on its name
     * @param name Name of the note file
     */
    public boolean removeNote(String name) {
        notes.remove(name);

        /*
        if (!fileManager.deleteEntry(topicName, name)) {
                    ui.printRemoveFail();
                    return false;
         }
         */
        return true;
    }

    public void printSortedOrder() {

    }
}
