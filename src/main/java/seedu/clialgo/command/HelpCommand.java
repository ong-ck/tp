package seedu.clialgo.command;

import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

import java.util.Objects;

public class HelpCommand extends Command {
    private String command;
    public HelpCommand() {
        command = null;
    }
    public HelpCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    @Override
    public void execute (TopicManager topicManager, Ui ui, FileManager fileManager) {
    }

    @Override
    public boolean equals(Command otherCommand) {
        HelpCommand otherHelpCommand = (HelpCommand) otherCommand;

        return Objects.equals(this.getCommand(), otherHelpCommand.getCommand());
    }
}
