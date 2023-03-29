package seedu.clialgo.command;

import seedu.clialgo.Buffer;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.file.CS2040CFile;
import seedu.clialgo.storage.FileManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * The <code>TopoCommand</code> object represents the user command to
 * print the topologically sorted CS2040CFiles after a specific target CS2040CFile.
 */
public class TopoCommand extends Command {

    private LinkedHashMap<String, ArrayList<String>> topoSortedCS2040CFiles;
    private final String name;

    /**
     * Constructor for command to print CS2040CFiles in a topological manner.
     *
     * @param name Name of the CS2040CFile.
     */
    public TopoCommand(String name) {
        this.topoSortedCS2040CFiles = new LinkedHashMap<>();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Prints all CS2040CFiles of a single specific topic.
     *
     * @param topicName The topic by which the CS2040CFiles are to be printed from.
     */
    private void printSingleTopic(String topicName) {
        ArrayList<String> cs2040cFiles = topoSortedCS2040CFiles.get(topicName);
        int serialNumber = 1;
        System.out.println("[" + topicName + "]");
        for (String cs2040cFile : cs2040cFiles) {
            System.out.println(serialNumber + ". " + cs2040cFile);
            serialNumber++;
        }
    }

    /**
     * Prints all CS2040CFiles after a specific target CS2040CFile in a topological manner.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all CS2040CFiles stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     */
    private ArrayList<CS2040CFile> printTopoSortedCS2040CFiles(TopicManager topicManager, Ui ui) {
        topoSortedCS2040CFiles = topicManager.getAllCS2040CFilesBeforeTopic(name);
        ui.printTopoSortSuccess();
        ArrayList<CS2040CFile> files = new ArrayList<>();
        for (String topicName : topoSortedCS2040CFiles.keySet()) {
            if (topoSortedCS2040CFiles.get(topicName).isEmpty()) {
                continue;
            }
            printSingleTopic(topicName);
            files.addAll(topicManager.getTopics().get(topicName).getCS2040CFilesAsArray());
        }
        ui.printDivider();
        return files;
    }

    /**
     * An overridden method to execute the user command to print the
     * topologically sorted CS2040CFiles after a specific target CS2040CFile.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all CS2040CFiles stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     * @param buffer The object responsible to export filtered files.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager, Buffer buffer) {
        if (topicManager.isEmpty()) {
            buffer.updateBuffer(new ArrayList<>());
            ui.printNoCS2040CFilesSaved();
            return;
        }

        // Check if cs2040cFileName is valid
        if (!topicManager.isRepeatedCS2040CFile(name)) {
            ui.printDivider();
            System.out.println("You do not have this CS2040CFile!");
            ui.printDivider();
            return;
        }

        ArrayList<CS2040CFile> files = printTopoSortedCS2040CFiles(topicManager, ui);
        buffer.updateBuffer(files);
    }

    /**
     * An overridden method that checks for equality of <code>TopoCommand</code> objects.
     *
     * @param otherCommand The other <code>TopoCommand</code> object to be checked against.
     * @return A boolean value to determine whether the <code>TopoCommand</code> objects are equal.
     */
    @Override
    public boolean equals(Command otherCommand) {
        TopoCommand otherTopoCommand = (TopoCommand) otherCommand;
        LinkedHashMap<String, ArrayList<String>> otherTopoSortedCS2040CFiles = otherTopoCommand.topoSortedCS2040CFiles;

        // Check name attribute is equal
        if (!Objects.equals(otherTopoCommand.name, this.name)) {
            return false;
        }

        // Check that all topics in otherTopoCommand are also present
        for (String topic : otherTopoSortedCS2040CFiles.keySet()) {
            if (!this.topoSortedCS2040CFiles.containsKey(topic)) {
                return false;
            }

            // Check that all CS2040CFiles in specific topic of otherTopoCommand are also present
            for (String cs2040cFile : otherTopoSortedCS2040CFiles.get(topic)) {
                if (!this.topoSortedCS2040CFiles.get(topic).contains(cs2040cFile)) {
                    return false;
                }

            }

            // Check that number of CS2040CFiles in topic is equal -> topic is equal
            if (otherTopoSortedCS2040CFiles.get(topic).size() == this.topoSortedCS2040CFiles.get(topic).size()) {
                return false;
            }
        }

        // Check that number of topics are equal -> topoSortedCS2040CFiles is equal
        return otherTopoSortedCS2040CFiles.size() == this.topoSortedCS2040CFiles.size();
    }
}
