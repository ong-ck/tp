package seedu.clialgo.storage;

import seedu.clialgo.file.File;

/**
 * Object that takes in a <code>File</code> object and converts it into a <code>String</code> which is then written
 * to the .txt file which the <code>File</code> has the <code>File.tag</code> of.
 */
public class FileEncoder {

    protected final String separator;

    /**
     * Constructor for the fileEncoder object.
     *
     * @param separator The <code>String</code> which separates each form of data stored in each <code>File</code>.
     */
    public FileEncoder (String separator) {
        this.separator = separator;
    }

    /**
     * Encodes a File into an encoded <code>String</code>.
     *
     * @param name The name of the <code>File</code>.
     * @param file The <code>File</code> object processed.
     * @return Returns a processed string.
     */
    public String encodeFile (String name, File file) {
        return name + separator + file.getPath() + separator + file.getTopic();
    }

}
