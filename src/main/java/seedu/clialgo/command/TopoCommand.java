package seedu.clialgo.command;

import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * The <code>TopoCommand</code> object represents the user command to
 * print the topologically sorted notes after a specific target note.
 */
public class TopoCommand extends Command {

    private LinkedHashMap<String, ArrayList<String>> topoSortedNotes;
    private final String name;

    /**
     * Constructor for command to print notes in a topological manner.
     *
     * @param name Name of the note file.
     */
    public TopoCommand(String name) {
        this.topoSortedNotes = new LinkedHashMap<>();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Prints all notes of a single specific topic.
     *
     * @param topicName The topic by which the notes are to be printed from.
     */
    private void printSingleTopic(String topicName) {
        ArrayList<String> notes = topoSortedNotes.get(topicName);
        int serialNumber = 1;
        System.out.println("[" + topicName + "]");
        for (String note : notes) {
            System.out.println(serialNumber + ". " + note);
            serialNumber++;
        }
    }

    /**
     * Prints all notes after a specific target note in a topological manner.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all notes stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     */
    public void printTopoSortedNotes(TopicManager topicManager, Ui ui) {
        topoSortedNotes = topicManager.getAllNotesBeforeTopic(name);
        ui.printTopoSortSuccess();
        for (String topicName : topoSortedNotes.keySet()) {
            if (!topoSortedNotes.get(topicName).isEmpty()) {
                printSingleTopic(topicName);
            }
        }
        ui.printDivider();
    }

    /**
     * An overridden method to execute the user command to print the
     * topologically sorted notes after a specific target note.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all notes stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     */
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

        printTopoSortedNotes(topicManager, ui);
    }

    /**
     * An overridden method that checks for equality of <code>TopoCommand</code> objects.
     *
     * @param otherCommand The other <code>TopoCommand</code> object to be checked against.
     * @return A boolean value to determine whether the <code>TopoCommand</code> objects are equal.
     */
    @Override
    public boolean equals(Command otherCommand) {
        return true;
    }
}
