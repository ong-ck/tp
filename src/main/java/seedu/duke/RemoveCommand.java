package seedu.duke;

/**
 * Represents an executable command from the user. A <code>RemoveCommand</code> object contains the name of
 * the note to be deleted. This object removes the note corresponding to the name of the note from the list when the
 * execute method is called.
 */
public class RemoveCommand extends Command {

    public String name;

    /**
     * Constructor for command to remove note from topic list.
     *
     * @param name Name of the note file.
     */
    public RemoveCommand(String name) {
        this.name = name;
    }

    /**
     * This method removes a note corresponding to <code>name</code> from the list. It then saves the
     * updated list.
     * @param topic A Topic object containing all the different topics available.
     * @param ui A Ui object which handles outputs to the user.
     * @param storage An object responsible for saving information.
     */
    @Override
    public void execute(Topic topic, Ui ui, Storage storage) {
        //topic.removeNote(name);
    }
}
