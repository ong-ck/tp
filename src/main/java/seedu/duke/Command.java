package seedu.duke;

public abstract class Command {

    public abstract void execute(Topic topic, Ui ui, Storage storage);
}
