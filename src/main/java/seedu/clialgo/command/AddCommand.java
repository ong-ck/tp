package seedu.clialgo.command;

import java.util.Objects;

import seedu.clialgo.storage.FileManager;
import seedu.clialgo.Topic;
import seedu.clialgo.Ui;


/**
 * The <code>AddCommand</code> objects represents the user command to add new notes into CLIAlgo.
 */
public class AddCommand extends Command {

    private String name;
    public String path;

    private String tag;

    /**
     * Constructor for command to add note to topic list.
     *
     * @param name Name of the note file.
     * @param tag The topic that this file is tagged to.
     */
    public AddCommand(String name, String tag) {
        this.name = name;
        this.path = name;
        this.tag = tag;
    }

    String getName() {
        return this.name;
    }

    String getTag() {
        return this.tag;
    }

    /**
     * An overridden method to execute the user command to add new notes into CLIAlgo.
     *
     * @param topic The <code>Topic</code> object.
     * @param ui The <code>Ui</code> object.
     * @param fileManager The <code>Storage</code> object.
     */
    @Override
    public void execute(Topic topic, Ui ui, FileManager fileManager) {
        boolean isAdded = topic.addNote(name, path);

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

        return Objects.equals(this.getName(), otherAddCommand.getName()) &&
                Objects.equals(this.getTag(), otherAddCommand.getTag());
    }
}
