package seedu.duke;

public class Note {

    public String name;
    public String path;
    public String tag;

    /**
     * Constructor for <code>Note</code> object.
     *
     * @param name Name of the note file.
     * @param path Path to the note file.
     * @param tag Topic that note file should be tagged.
     */
    public Note(String name, String path, String tag) {
        this.name = name;
        this.path = path;
        this.tag = tag;
    }

    public void printNoteName() {
        System.out.println(name);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
