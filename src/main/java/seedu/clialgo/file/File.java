package seedu.clialgo.file;

public abstract class File {
    protected String name;
    protected String path;
    protected String topic;
    protected int importance;
    protected String type;

    /**
     * Prints the name of the file.
     */
    public void printNoteName() {
        System.out.println(name);
    }

    public String getName() {
        return this.name;
    }

    /**
     * Gets the location path of the file.
     *
     * @return The location path of the file.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the location path of the file.
     *
     * @param path The new location path of the file.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the tag of the file.
     *
     * @return The tag of the file.
     */
    public String getTopic() {
        return this.topic;
    }

    /**
     * Sets the tag of the file.
     *
     * @param topic The new tag for the file.
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getType() {
        return type;
    }

    public int getImportance() {
        return importance;
    }
}
