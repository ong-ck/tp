package seedu.clialgo.file;

<<<<<<< HEAD
public class Code extends File {

    public Code(String name, String path, String topic) {
        this.name = name;
        this.path = path;
        this.topic = topic;
        this.type = "CODE";
    }
    public Code(String name, String path, String topic, int importance) {
        this.name = name;
        this.path = path;
        this.topic = topic;
        this.importance = importance;
        this.type = "CODE";
=======
public class Code extends CS2040CFile {
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
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
    }
}
