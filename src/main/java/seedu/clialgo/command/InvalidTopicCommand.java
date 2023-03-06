package seedu.clialgo.command;

import seedu.clialgo.Topic;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

public class InvalidTopicCommand extends Command {
    @Override
    public void execute (Topic topic, Ui ui, FileManager fileManager) {
    }

    @Override
    public boolean equals(Command otherCommand) {
        return otherCommand instanceof InvalidTopicCommand;
    }
}
