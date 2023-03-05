package seedu.clialgo;

public class FilterCommand extends Command {
    String keyWord;
    String topic;

    public FilterCommand(String keyWord, String topic) {
        this.keyWord = keyWord;
        this.topic = topic;
    }
}
