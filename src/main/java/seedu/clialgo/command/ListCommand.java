package seedu.clialgo.command;

import seedu.clialgo.Buffer;
import seedu.clialgo.logic.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

import java.util.ArrayList;

public class ListCommand extends Command {
    /**
     * This method prints all the CS2040CFiles stored in CLIAlgo.
     * If there are no CS2040CFiles stored in CLIAlgo, this method informs the user that the topicManager is empty.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all CS2040CFiles stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     * @param buffer The object responsible to export filtered files.
     */
    @Override
    public void execute (TopicManager topicManager, Ui ui, FileManager fileManager, Buffer buffer) {
        if (topicManager.isEmpty()) {
            ui.printListFail();
            return;
        }
        ui.printListSuccess();
        ArrayList<String> printedCS2040CFiles = topicManager.getAllCS2040CFiles();
        ui.printListOfCS2040CFiles(printedCS2040CFiles);
        ui.printDivider();
    }

    @Override
    public boolean equals(Command otherCommand) {
        return otherCommand instanceof ListCommand;
    }
}
