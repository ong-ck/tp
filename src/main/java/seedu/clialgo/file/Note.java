package seedu.clialgo.file;

/**
 * The <code>Note</code> object represents each note file that the user can add into CLIAlgo.
 */
public class Note extends File {

    /**
     * Constructor for <code>Note</code> object.
     *
     * @param name Name of the note file.
     * @param path Path to the note file.
     * @param topic Topic that note file should be tagged.
     */
    public Note(String name, String path, String topic) {
        this.name = name;
        this.path = path;
        this.topic = topic;
        this.type = "NOTE";
    }

    public Note(String name, String path, String topic, int importance) {
        this.name = name;
        this.path = path;
        this.topic = topic;
        this.importance = importance;
        this.type = "NOTE";
    }
}
