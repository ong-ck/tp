package seedu.clialgo.command;

import seedu.clialgo.Buffer;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

import java.util.ArrayList;
import java.util.Objects;

public class FilterCommand extends Command {
    protected final String keyWord;
    protected final String topic;

    public FilterCommand(String keyWord, String topic) {
        this.keyWord = keyWord;
        this.topic = topic;
    }

    /**
     * This method prints all the CS2040CFiles stored across all non-empty topics in CLIAlgo.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all CS2040CFiles stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     */
    public void printAllTopics(TopicManager topicManager, Ui ui) {
    }

    /**
     * This method prints all the CS2040CFile stored in a single specified topic.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all CS2040CFiles stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     */
    public void printSingleTopic(TopicManager topicManager, Ui ui) {
    }

    /**
     * Prints the CS2040CFile stored in all topics or just a single topics depending on the topic.
     * If there are no CS2040CFiles stored in CLIAlgo or in the given topic, it prints a string to inform the user.
     * If an invalid topic is given, it prints a string to inform the reader.
     *
     * @param topicManager The <code>TopicManager</code> object which handles all CS2040CFiles stored in CLIAlgo.
     * @param ui The <code>Ui</code> object which handles outputs to the user.
     * @param fileManager The <code>FileManager</code> object responsible for saving information in CLIAlgo.
     * @param buffer The object responsible to export filtered files.
     */
    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager, Buffer buffer) {
        if (topicManager.isEmpty()) {
            ui.printFilterEmpty();
            buffer.updateBuffer(new ArrayList<>());
            return;
        }

        if (keyWord.equals("topic")) {
            new FilterByTopicCommand(keyWord, topic).execute(topicManager, ui, fileManager, buffer);
        } else if (keyWord.equals("importance")) {
            new FilterByImportanceCommand(keyWord, topic).execute(topicManager, ui, fileManager, buffer);
        } else {
            ui.printInvalidCommand();
        }
    }

    @Override
    public boolean equals(Command otherCommand) {
        FilterCommand otherFilterCommand = (FilterCommand) otherCommand;

        return Objects.equals(this.keyWord, otherFilterCommand.keyWord) &&
                Objects.equals(this.topic, otherFilterCommand.topic);
    }
}
