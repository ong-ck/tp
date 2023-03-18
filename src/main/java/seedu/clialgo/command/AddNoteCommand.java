package seedu.clialgo.command;

public class AddNoteCommand extends AddCommand {
    /**
     * Constructor for command to add note to topic list.
     *
     * @param name  Name of the note file.
     * @param topic The topic that this file is tagged to.
     */
    public AddNoteCommand(String name, String topic) {
        super(name, topic);
    }
}
