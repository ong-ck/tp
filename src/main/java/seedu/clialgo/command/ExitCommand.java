package seedu.clialgo.command;

import seedu.clialgo.storage.FileManager;
import seedu.clialgo.Topic;
import seedu.clialgo.Ui;

/**
 * Represents an executable command. A <code>ExitCommand</code> object is created whenever the
 * user decides to exit the program.
 */
public class ExitCommand extends Command {
    /**
     * This method closes the scanner and exits from the program
     * @param topic
     * @param ui
     * @param fileManager
     */
    @Override
    public void execute (Topic topic, Ui ui, FileManager fileManager) {
        //ui.closeScanner();
        //ui.exitProgram();
    }

    /**
     * An overridden method that checks for equality of <code>ExitCommand</code> objects.
     *
     * @param otherCommand The other <code>ExitCommand</code> object to be checked against.
     * @return A boolean value to determine whether the <code>ExitCommand</code> objects are equal.
     */
    @Override
    public boolean equals(Command otherCommand) {
        return otherCommand instanceof ExitCommand;
    }
}
