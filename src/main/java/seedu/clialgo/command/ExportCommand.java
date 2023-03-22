package seedu.clialgo.command;

import seedu.clialgo.Buffer;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

public class ExportCommand extends Command {

    /**
     * Exports the files currently stored in the buffer
     *
     * @param topicManager The <code>TopicManager</code> object which handles all CS2040CFiles stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     * @param buffer The object responsible to export filtered files.
     */
    public void execute (TopicManager topicManager, Ui ui, FileManager fileManager, Buffer buffer) {
        buffer.exportBuffer();
    }

    public boolean equals(Command otherCommand) {
        return otherCommand instanceof ExportCommand;
    }
}
