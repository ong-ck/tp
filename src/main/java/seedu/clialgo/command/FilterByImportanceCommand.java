package seedu.clialgo.command;

import seedu.clialgo.Buffer;
import seedu.clialgo.Topic;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.file.CS2040CFile;
import seedu.clialgo.storage.FileManager;

import java.util.ArrayList;
import java.util.Comparator;

public class FilterByImportanceCommand extends FilterCommand {
    public FilterByImportanceCommand(String keyWord, String topic) {
        super(keyWord, topic);
    }

    // Method
    // Comparator for sorting by importance
    public Comparator<CS2040CFile> importanceLevel = (cs2040cFile1, cs2040cFile2) -> {
        int cs2040cFile1Importance = cs2040cFile1.getImportance();
        int cs2040cFile2Importance = cs2040cFile2.getImportance();
        // From most important to the least important
        return cs2040cFile2Importance - cs2040cFile1Importance;
    };


    @Override
    public void printAllTopics(TopicManager topicManager, Ui ui) {
        ArrayList<CS2040CFile> cs2040cFiles = topicManager.getAllFilesAsFiles();
        ui.printFilterSuccess();
        cs2040cFiles.sort(importanceLevel);
        int serialNumber = 1;
        for (CS2040CFile cs2040CFile : cs2040cFiles) {
            System.out.println(serialNumber + ". " + cs2040CFile.getName());
            ++serialNumber;
        }
    }

    @Override
    public void printSingleTopic(TopicManager topicManager, Ui ui) {
        ArrayList<CS2040CFile> cs2040cFiles = topicManager.getOneTopic(this.topic).getCS2040CFilesAsArray();
        ui.printFilterSuccess();
        cs2040cFiles.sort(importanceLevel);
        int serialNumber = 1;
        System.out.println("[" + this.topic + "]");
        for (CS2040CFile cs2040cFile : cs2040cFiles) {
            System.out.println(serialNumber + ". " + cs2040cFile.getName());
            ++serialNumber;
        }

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