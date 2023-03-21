package seedu.clialgo.file;

public abstract class File {
    protected String name;
    protected String path;
    protected String topic;
    protected int importance;

    /**
     * Constructor for <code>Note</code> object.
     *
     * @param name Name of the file.
     * @param path Path to the file.
     * @param topic Topic that file should be tagged.
     */
    public File(String name, String path, String topic) {
        this.name = name;
        this.path = path;
        this.topic = topic;
    }

    /**
     * Prints the name of the file.
     */
    public abstract void printFileName();

    public abstract String getName();

    /**
     * Gets the location path of the file.
     *
     * @return The location path of the file.
     */
    public abstract String getPath();

    /**
     * Sets the location path of the file.
     *
     * @param path The new location path of the file.
     */
    public abstract void setPath(String path);

    /**
     * Gets the tag of the file.
     *
     * @return The tag of the file.
     */
    public abstract String getTopic();

    /**
     * Sets the tag of the file.
     *
     * @param topic The new tag for the file.
     */
    public abstract void setTopic(String topic);
}
