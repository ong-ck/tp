package seedu.duke;

public class RemoveCommand extends Command {

    public String name;

    /**
     * Constructor for command to remove note from topic list.
     *
     * @param name Path of the note file.
     */
    public RemoveCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(Topic topic, Ui ui, Storage storage) {
        topic.removeNote(name);
    }
}
