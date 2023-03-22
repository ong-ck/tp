package seedu.clialgo.command;

import java.util.Objects;
import java.io.File;

import seedu.clialgo.FileType;
import seedu.clialgo.TopicManager;
import seedu.clialgo.storage.FileManager;
import seedu.clialgo.Ui;

/**
 * The <code>AddCommand</code> objects represents the user command to add new CS2040CFiles into CLIAlgo.
 */
public class AddCommand extends Command {

    protected final String name;
    protected final Ui ui;
    protected final String topic;

    /**
     * Constructor for command to add CS2040CFile to topic list.
     *
     * @param name Name of the CS2040CFile.
     * @param topic The topic that this file is tagged to.
     */
    public AddCommand(String name, String topic) {
        this.name = name;
        this.topic = topic;
        this.ui = new Ui();
    }

    String getName() {
        return this.name;
    }

    String getTag() {
        return this.topic;
    }

    /**
     * Checks if the file exists as a .txt or .cpp.
     *
     * @return A <code>FileType</code> enum that determines whether the file DOESNOTEXIST, is a TXT or CPP file.
     */
    public FileType checkFileType() {
        String pathInTxt = this.name + ".txt";
        String pathInCpp = this.name + ".cpp";

        if (new File(".\\" + pathInTxt).isFile()) {
            return FileType.TXT;
        } else if (new File(".\\" + pathInCpp).isFile()) {
            return FileType.CPP;
        } else {
            return FileType.DOESNOTEXIST;
        }
    }

    /**
     * An overridden method to execute the user command to add new CS2040CFiles into CLIAlgo.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all CS2040CFiles stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager) {
<<<<<<< HEAD
        String notePath = ".\\" + name + ".txt";
        Note newNote = new Note(name, notePath, topic);
=======
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
        boolean isTestModeOn = topicManager.getIsTestModeOn();

        // Check if the file exists
        if ((checkFileType() == FileType.DOESNOTEXIST) && !isTestModeOn) {
            ui.printFileDoesNotExist();
            return;
        }

        // Check if topicName is valid
        if (!topicManager.isValidTopic(topic)) {
            new InvalidTopicCommand(topic).execute(topicManager, ui, fileManager);
            return;
        }
        // Check if the note is repeated
        if (topicManager.isRepeatedCS2040CFile(name)) {
            assert topicManager.isRepeatedCS2040CFile(name);
            ui.printCS2040CFileExists();
            return;
        }

<<<<<<< HEAD
        boolean isAddedToFile = fileManager.addEntry(name, newNote, null);

        //  Check if note is successfully added to data file
        if (!isAddedToFile) {
            return;
        }

        boolean isAdded = topicManager.addNote(name, topic, newNote);

        // Check if added -> execute invalid command if note is not added
        if (!isAdded) {
            new InvalidCommand().execute(topicManager, ui, fileManager);
            return;
=======
        if (checkFileType() == FileType.TXT) {
            new AddNoteCommand(name, topic).execute(topicManager, ui, fileManager);
        } else if (checkFileType() == FileType.CPP) {
            new AddCodeCommand(name, topic).execute(topicManager, ui, fileManager);
        } else if (checkFileType() == FileType.DOESNOTEXIST && isTestModeOn) {
            new AddNoteCommand(name, topic).execute(topicManager, ui, fileManager);
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
        }

        assert this.name != null;
        assert this.topic != null;
        assert topicManager.isValidTopic(topic);
        // Ui for successful adding
        ui.printAddSuccess(name, topic);
    }

    /**
     * An overridden method that checks for equality of <code>AddCommand</code> objects.
     *
     * @param otherCommand The other <code>AddCommand</code> object to be checked against.
     * @return A boolean value to determine whether the <code>AddCommand</code> objects are equal.
     */
    @Override
    public boolean equals(Command otherCommand) {
        AddCommand otherAddCommand = (AddCommand) otherCommand;

        return Objects.equals(this.getName(), otherAddCommand.getName()) &&
                Objects.equals(this.getTag(), otherAddCommand.getTag());
    }
}
