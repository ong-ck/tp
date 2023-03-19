package seedu.clialgo.command;

import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class TopoCommand extends Command {

    private LinkedHashMap<String, ArrayList<String>> toposortedNotes;
    private final String name;

    /**
     * Constructor for command to print notes in a topological manner.
     *
     * @param name Name of the note file.
     */
    public TopoCommand(String name) {
        this.toposortedNotes = new LinkedHashMap<>();
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    public void printSingleTopic(Ui ui, String topicName) {
        ArrayList<String> notes = toposortedNotes.get(topicName);
        int serialNumber = 1;
        System.out.println("[" + topicName + "]");
        for (String note : notes) {
            System.out.println(serialNumber + ". " + note);
            serialNumber++;
        }
    }

    public void printToposortedNotes(TopicManager topicManager, Ui ui) {
        toposortedNotes = topicManager.getAllNotesAfterTopic(name);
        ui.printToposortSuccess();
        for (String topicName : toposortedNotes.keySet()) {
            if (!toposortedNotes.get(topicName).isEmpty()) {
                printSingleTopic(ui, topicName);
            }
        }
        ui.printDivider();
    }

    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager) {
        if (topicManager.isEmpty()) {
            System.out.println("You have no notes at the moment!");
            return;
        }

        // Check if noteName is valid
        if (!topicManager.isRepeatedNote(name)) {
            System.out.println("You do not have this note!");
            return;
        }

        printToposortedNotes(topicManager, ui);
    }

    @Override
    public boolean equals(Command otherCommand) {
        return false;
    }
}
