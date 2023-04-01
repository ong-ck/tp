package seedu.clialgo.command;

import seedu.clialgo.Buffer;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.file.Code;
import seedu.clialgo.storage.FileManager;

public class AddCodeCommand extends AddCommand {

    /**
     * Constructor for command to add code file to topic list.
     *
     * @param name Name of the code file.
     * @param topic The topic that this file is tagged to.
     */
    public AddCodeCommand(String name, String topic) {
        super(name, topic);
    }

    /**
     * Constructor for command to add code file to topic list.
     *
     * @param name Name of the code file.
     * @param topic The topic that this file is tagged to.
     * @param importance The importance of the code file.
     */
    public AddCodeCommand(String name, String topic, int importance) {
        super(name, topic, importance);
    }

    /**
     * An overridden method to execute the user command to add new code files into CLIAlgo.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all files stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     * @param buffer The object responsible to export filtered files.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager, Buffer buffer) {
        String codePath = name + ".cpp";
        fileManager.recreateAll();
        Code newCode = new Code(name, codePath, topic, importance);
        boolean isAddedToFile = fileManager.addEntry(name, newCode);

        //  Check if code file is successfully added to data file
        if (!isAddedToFile) {
            return;
        }

        boolean isAdded = topicManager.addCS2040CFile(name, topic, newCode);

        // Check if added -> execute invalid command if code file is not added
        if (!isAdded) {
            new InvalidCommand().execute(topicManager, ui, fileManager, buffer);
        }
    }
}
