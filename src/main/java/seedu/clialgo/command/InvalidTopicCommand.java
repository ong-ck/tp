package seedu.clialgo.command;

import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

public class InvalidTopicCommand extends Command {
    @Override
    public void execute (TopicManager topicManager, Ui ui, FileManager fileManager) {
    }

    @Override
    public boolean equals(Command otherCommand) {
        return otherCommand instanceof InvalidTopicCommand;
    }
}
