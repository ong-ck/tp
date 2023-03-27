package seedu.clialgo.command;

import seedu.clialgo.Buffer;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

public class InvalidImportanceCommand extends Command {
    private final String importance;

    public InvalidImportanceCommand(String importance) {
        this.importance = importance;
    }

    @Override
    public void execute(TopicManager topicManager, Ui ui, FileManager fileManager, Buffer buffer) {
        ui.printInvalidImportance(importance);
    }

    @Override
    public boolean equals(Command otherCommand) {
        return false;
    }
}
