package seedu.clialgo.command;

import java.util.Objects;

import seedu.clialgo.Note;
import seedu.clialgo.TopicManager;
import seedu.clialgo.storage.FileManager;
import seedu.clialgo.Ui;

/**
 * The <code>AddCommand</code> objects represents the user command to add new notes into CLIAlgo.
 */
public class AddCommand extends Command {

    private String name;
    private String topic;

    /**
     * Constructor for command to add note to topic list.
     *
     * @param name Name of the note file.
     * @param topic Topic linked to the note file.
     */
    public AddCommand(String name, String topic) {
        this.name = name;
        this.topic = topic;
    }

    /**
     * An overridden method to execute the user command to add new notes into CLIAlgo.
     *
     * @param topicManager The <code>TopicManager</code> object.
     * @param ui The <code>Ui</code> object.
     * @param fileManager The <code>Storage</code> object.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager) {
        String notePath = name + ".txt";
        Note newNote = new Note(name, notePath, topic);

        // Save note in FileManager first -> if failed, will not be added to internal hashmap
        if (!fileManager.addEntry(name, newNote)) {
            ui.printSaveUnsuccessful();
            return;
        }

        boolean isAdded = topicManager.addNote(name, topic, newNote);

        // Check if added -> execute invalid command if note is not added
        if (!isAdded) {
            new InvalidCommand();
            return;
        }

        // Check if topicName is valid
        if (!topicManager.isValidTopic(topic)) {
            ui.printAddFail(topic);
            return;
        }

        // Ui for successful adding
        ui.printAddSuccess(name, topic);
    }

    /**
     * An overridden method that checks for equality of <code>AddCommand</code> objects.
     *
     * @param otherCommand The other <code>AddCommand</code> object to be checked against.
     * @return A boolean value to determine whether the <code>AddCommand</code> objects are equal.
     */
    @Override
    public boolean equals(Command otherCommand) {
        AddCommand otherAddCommand = (AddCommand) otherCommand;

        return Objects.equals(this.name, otherAddCommand.name) &&
                Objects.equals(this.topic, otherAddCommand.topic);
    }
}
