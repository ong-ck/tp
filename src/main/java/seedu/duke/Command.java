package seedu.duke;

/**
 * Represents an executable command from the user. A <code>Command</code> object contains the details needed to execute
 * the command. Each subclass of <code>Command</code> will have an overridden method <code>execute</code> which has its
 * own implementation.
 */
public abstract class Command {
    /**
     * This method is to be overridden by each subclass for different implementations.
     *
     * @param topic A Topic object containing all the different topics available.
     * @param ui A Ui object which handles outputs to the user.
     * @param storage An object responsible for saving information.
     */
    public abstract void execute(Topic topic, Ui ui, Storage storage);
}
