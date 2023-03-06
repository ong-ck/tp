package seedu.duke;

/**
 * The <code>Note</code> object represents each note file that the user can add into CLIAlgo.
 */
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

    /**
     * Prints the name of the note file.
     */
    public void printNoteName() {
        System.out.println(name);
    }

    /**
     * Gets the location path of the note file.
     *
     * @return The location path of the note file.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the location path of the note file.
     *
     * @param path The new location path of the note file.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the tag of the note file.
     *
     * @return The tag of the note file.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the tag of the note file.
     *
     * @param tag The new tag for the note file.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }
}
