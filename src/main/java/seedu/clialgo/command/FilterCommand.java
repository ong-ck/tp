package seedu.clialgo.command;

import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FilterCommand extends Command {
    String keyWord;
    String topic;

    public FilterCommand(String keyWord, String topic) {
        this.keyWord = keyWord;
        this.topic = topic;
    }

    public void printAllTopics(TopicManager topicManager, Ui ui) {
        HashMap<String, ArrayList<String>> notes = topicManager.getAllNotesByTopic();
        ui.printFilterSuccess();
        for (Map.Entry<String, ArrayList<String>> entry : notes.entrySet()) {
            ArrayList<String> currentTopicNotes = entry.getValue();
            String topicName = entry.getKey();
            int serialNumber = 1;
            System.out.println("[" + topicName + "]");
            for (String note : currentTopicNotes) {
                System.out.println(serialNumber + ". " + note);
                serialNumber++;
            }
        }
        ui.printDivider();
    }

    public void printSingleTopic(TopicManager topicManager, Ui ui) {
        ArrayList<String> notes = topicManager.getNotesByTopic(this.topic);
        ui.printFilterSuccess();
        int serialNumber = 1;
        System.out.println("[" + this.topic + "]");
        for (String note : notes) {
            System.out.println(serialNumber + ". " + note);
            serialNumber++;
        }
        ui.printDivider();
    }

    @Override
    public void execute (TopicManager topicManager, Ui ui, FileManager fileManager) {
        if (topicManager.isEmpty()) {
            ui.printFilterFail();
            return;
        }
        if (this.topic == null) {
            printAllTopics(topicManager, ui);
        }
        if (!topicManager.isValidTopic(this.topic)) {
            new InvalidTopicCommand().execute(topicManager, ui, fileManager);
            return;
        }
        if (topicManager.isTopicEmpty(this.topic)) {
            ui.printFilterFail();
            return;
        }
        printSingleTopic(topicManager, ui);
    }

    @Override
    public boolean equals(Command otherCommand) {
        FilterCommand otherFilterCommand = (FilterCommand) otherCommand;

        return Objects.equals(this.keyWord, otherFilterCommand.keyWord) &&
                Objects.equals(this.topic, otherFilterCommand.topic);
    }
}
