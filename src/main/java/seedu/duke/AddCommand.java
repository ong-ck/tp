package seedu.duke;

import java.util.Objects;

/**
 * The <code>AddCommand</code> objects represents the user command to add new notes into CLIAlgo.
 */
public class AddCommand extends Command {

    public String name;
    public String path;

    /**
     * Constructor for command to add note to topic list.
     *
     * @param name Name of the note file.
     * @param path Path of the note file.
     */
    public AddCommand(String name, String path) {
        this.name = name;
        this.path = path;
    }

    /**
     * An overridden method to execute the user command to add new notes into CLIAlgo.
     *
     * @param topic The <code>Topic</code> object.
     * @param ui The <code>Ui</code> object.
     * @param storage The <code>Storage</code> object.
     */
    @Override
    public void execute(Topic topic, Ui ui, Storage storage) {
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

        return Objects.equals(this.name, otherAddCommand.name) &&
                Objects.equals(this.path, otherAddCommand.path);
    }
}
