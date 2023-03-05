package seedu.duke;

/**
 * Represents an executable command. A <code>ExitCommand</code> object is created whenever the user decides to exit the program.
 */
public class ExitCommand extends Command {
    /**
     * This method closes the scanner and exits from the program
     * @param topic
     * @param ui
     * @param storage
     */
    @Override
    public void execute (Topic topic, Ui ui, Storage storage) {
        //ui.closeScanner();
        //ui.exitProgram();
    }

}
