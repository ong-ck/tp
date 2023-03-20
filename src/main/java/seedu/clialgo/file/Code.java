package seedu.clialgo.file;

public class Code extends File {
    /**
     * Constructor for <code>Code</code> object.
     *
     * @param name Name of the code file.
     * @param path Path to the code file.
     * @param topic Topic that code file should be tagged.
     */
    public Code(String name, String path, String topic) {
        super(name, path, topic);
    }

    /**
     * Prints the name of the code file.
     */
    @Override
    public void printFileName() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the location path of the code file.
     *
     * @return The location path of the code file.
     */
    @Override
    public String getPath() {
        return path;
    }

    /**
     * Sets the location path of the code file.
     *
     * @param path The new location path of the code file.
     */
    @Override
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the tag of the code file.
     *
     * @return The tag of the code file.
     */
    @Override
    public String getTopic() {
        return this.topic;
    }

    /**
     * Sets the tag of the code file.
     *
     * @param topic The new tag for the code file.
     */
    @Override
    public void setTopic(String topic) {
        this.topic = topic;
    }
}
