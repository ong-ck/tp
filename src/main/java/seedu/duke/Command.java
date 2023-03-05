package seedu.duke;

/**
 * A <code>Command</code> object represents any command made by the user.
 * This is an abstract class that will be inherited by its subclasses to
 * execute specific commands by the user.
 */
public abstract class Command {

    /**
     * A method to be overridden by the subclasses to execute specific commands by the user.
     *
     * @param topic The <code>Topic</code> object.
     * @param ui The <code>Ui</code> object.
     * @param storage The <code>Storage</code> object.
     */
    public abstract void execute(Topic topic, Ui ui, Storage storage);

    /**
     * A method to be overridden by the subclasses to check for equality of the instantiated objects.
     *
     * @param otherCommand The other object to be checked against.
     * @return A boolean value to determine whether the commands are equal.
     */
    public abstract boolean equals(Command otherCommand);
}
