package seedu.clialgo.command;

import seedu.clialgo.FileType;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;
import seedu.clialgo.file.Note;

public class AddNoteCommand extends AddCommand {
    /**
     * Constructor for command to add note to topic list.
     *
     * @param name  Name of the note file.
     * @param topic The topic that this file is tagged to.
     */
    public AddNoteCommand(String name, String topic) {
        super(name, topic);
    }

    /**
     * An overridden method to execute the user command to add new notes into CLIAlgo.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all files stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager) {
        String notePath = name + ".txt";
        Note newNote = new Note(name, notePath, topic);
        boolean isAddedToFile = fileManager.addEntry(name, newNote);

        //  Check if note is successfully added to data file
        if (!isAddedToFile) {
            return;
        }

        boolean isAdded = topicManager.addFile(name, topic, newNote);

        // Check if added -> execute invalid command if note is not added
        if (!isAdded) {
            new InvalidCommand().execute(topicManager, ui, fileManager);
            return;
        }
    }
}
