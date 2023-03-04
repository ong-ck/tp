package seedu.duke;

public class AddCommand extends Command {

    public String name;
    public String path;

    /**
     * Constructor for command to add note to topic list.
     *
     * @param name Name of the note file.
     * @param path Path of the note file.
     */
    public AddCommand(String name, String path) {
        this.name = name;
        this.path = path;
    }

    @Override
    public void execute(Topic topic, Ui ui, Storage storage) {
        boolean isAdded = topic.addNote(name, path);

        // Check if added -> execute invalid command if note added

        // Save list into Storage

        // Ui for successful adding
    }
}
