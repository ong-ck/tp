package seedu.duke;

/**
 * Represents an executable command. A <code>InvalidCommand</code> object is created whenever the user enters an invalid
 * command and is unable to generate the appropriate <code>Command</code> object.
 */
public class InvalidCommand extends Command {

    /**
     * This method informs the user that they have keyed in an invalid command.
     */
    public void execute(Topic topic, Ui ui, Storage storage) {
        //ui.printInvalidCommand();
    }
}
