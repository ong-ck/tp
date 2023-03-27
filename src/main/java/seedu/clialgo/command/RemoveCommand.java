package seedu.clialgo.command;

import java.util.Objects;

import seedu.clialgo.Buffer;
import seedu.clialgo.TopicManager;
import seedu.clialgo.storage.FileManager;
import seedu.clialgo.Ui;


/**
 * Represents an executable command from the user. A <code>RemoveCommand</code> object contains the name of
 * the CS2040CFile to be deleted. This object removes the CS2040CFile corresponding to the name of the CS2040CFile from
 * the list when the execute method is called.
 */
public class RemoveCommand extends Command {

    private final String name;

    /**
     * Constructor for command to remove CS2040CFile from topic list.
     *
     * @param name Name of the CS2040CFile.
     */
    public RemoveCommand(String name) {
        this.name = name;
    }

    /**
     * Overridden method that removes a CS2040CFile corresponding to <code>name</code> from the list. It then saves the
     * updated list.
     *
     * @param topicManager A Topic object containing all the different topics available.
     * @param ui A Ui object which handles outputs to the user.
     * @param fileManager An object responsible for saving information.
     * @param buffer The object responsible to export filtered files.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager, Buffer buffer) {
        if (topicManager.isEmpty()) {
            ui.printRemoveFail();
            return;
        }

        String topicName = topicManager.getTopicOfCS2040CFile(this.name);

        assert topicManager.isRepeatedCS2040CFile(this.name);
        boolean isSuccessfullyRemoved = topicManager.removeCS2040CFile(this.name, topicName);

        if (!isSuccessfullyRemoved) {
            ui.printRemoveFail();
            return;
        }

        boolean isDeletedInFile = fileManager.deleteEntry(name, topicName);

        if (!isDeletedInFile) {
            return;
        }
        ui.printRemoveSuccess(name);
    }

    /**
     * Gets the name of the CS2040CFile to be removed.
     *
     * @return Name of the CS2040CFile.
     */
    public String getName() {
        return name;
    }

    /**
     * An overridden method that checks for equality of <code>RemoveCommand</code> objects.
     *
     * @param otherCommand The other <code>RemoveCommand</code> object to be checked against.
     * @return A boolean value to determine whether the <code>RemoveCommand</code> objects are equal.
     */
    @Override
    public boolean equals(Command otherCommand) {
        RemoveCommand otherRemoveCommand = (RemoveCommand) otherCommand;
        return Objects.equals(this.name, otherRemoveCommand.name);
    }
}
