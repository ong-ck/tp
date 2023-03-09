package seedu.clialgo.command;

import java.util.Objects;

import seedu.clialgo.Note;
import seedu.clialgo.TopicManager;
import seedu.clialgo.storage.FileManager;
import seedu.clialgo.Ui;

/**
 * The <code>AddCommand</code> objects represents the user command to add new notes into CLIAlgo.
 */
public class AddCommand extends Command {

    private String name;
    private String topic;

    /**
     * Constructor for command to add note to topic list.
     *
     * @param name Name of the note file.
     * @param topic The topic that this file is tagged to.
     */
    public AddCommand(String name, String topic) {
        this.name = name;
        this.topic = topic;
    }

    String getName() {
        return this.name;
    }

    String getTag() {
        return this.topic;
    }

    /**
     * An overridden method to execute the user command to add new notes into CLIAlgo.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all notes stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager) {
        String notePath = name + ".txt";
        Note newNote = new Note(name, notePath, topic);

        // Save note in FileManager first -> if failed, will not be added to internal hashmap
        // Commented as fileManager methods are not fully developed yet
        /*
        if (!fileManager.addEntry(name, newNote)) {
                    ui.printSaveUnsuccessful();
                    return;
                }
         */

        // Check if topicName is valid
        if (!topicManager.isValidTopic(topic)) {
            new InvalidTopicCommand(topic).execute(topicManager, ui, fileManager);
            return;
        }

        boolean isAdded = topicManager.addNote(name, topic, newNote);

        // Check if added -> execute invalid command if note is not added
        if (!isAdded) {
            new InvalidCommand().execute(topicManager, ui, fileManager);
            return;
        }

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
