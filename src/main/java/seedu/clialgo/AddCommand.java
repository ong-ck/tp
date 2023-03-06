package seedu.clialgo;

public class AddCommand extends Command {
    String noteName;
    String topicName;
    public AddCommand(String noteName, String topicName) {
        this.noteName = noteName;
        this.topicName = topicName;
    }
}
