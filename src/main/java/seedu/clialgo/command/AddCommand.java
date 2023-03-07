package seedu.clialgo.command;

import java.util.Objects;

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
     * @param topicManager The <code>Topic</code> object.
     * @param ui The <code>Ui</code> object.
     * @param fileManager The <code>Storage</code> object.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager) {
        boolean isAdded = topicManager.addNote(name, topic);

        // Check if added -> execute invalid command if note added

        // Save list into Storage

        // Ui for successful adding
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
