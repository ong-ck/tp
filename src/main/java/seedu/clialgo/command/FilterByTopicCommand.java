package seedu.clialgo.command;

import seedu.clialgo.Buffer;
import seedu.clialgo.Topic;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.file.CS2040CFile;
import seedu.clialgo.storage.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FilterByTopicCommand extends FilterCommand {

    public FilterByTopicCommand(String keyWord, String topic) {
        super(keyWord, topic);
    }

    @Override
    public void printAllTopics(TopicManager topicManager, Ui ui) {
        HashMap<String, ArrayList<String>> cs2040cFiles = topicManager.getAllCS2040CFilesByTopic();
        ui.printFilterSuccess();
        for (Map.Entry<String, ArrayList<String>> entry : cs2040cFiles.entrySet()) {
            ArrayList<String> currentTopicCS2040CFiles = entry.getValue();
            String topicName = entry.getKey();
            int serialNumber = 1;
            System.out.println("[" + topicName + "]");
            for (String cs2040cFile : currentTopicCS2040CFiles) {
                System.out.println(serialNumber + ". " + cs2040cFile);
                serialNumber++;
            }
        }
        ui.printDivider();
    }

    @Override
    public void printSingleTopic(TopicManager topicManager, Ui ui) {
        ArrayList<String> cs2040cFiles = topicManager.getCS2040CFilesByTopic(this.topic);
        ui.printFilterSuccess();
        int serialNumber = 1;
        System.out.println("[" + this.topic + "]");
        for (String cs2040cFile : cs2040cFiles) {
            System.out.println(serialNumber + ". " + cs2040cFile);
            serialNumber++;
        }
        ui.printDivider();
    }

    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager, Buffer buffer) {
        if (this.topic == null) {
            printAllTopics(topicManager, ui);
            buffer.updateBuffer(topicManager.getAllFilesAsFiles());
            return;
        }
        if (!topicManager.isValidTopic(this.topic)) {
            new InvalidTopicCommand(this.topic).execute(topicManager, ui, fileManager, buffer);
            return;
        }
        if (topicManager.isTopicEmpty(this.topic)) {
            ui.printFilterFail();
            buffer.updateBuffer(new ArrayList<>());
            return;
        }
        printSingleTopic(topicManager, ui);
        Topic topic = topicManager.getOneTopic(this.topic);
        ArrayList<CS2040CFile> files = topic.getCS2040CFilesAsArray();
        buffer.updateBuffer(files);
    }
}
