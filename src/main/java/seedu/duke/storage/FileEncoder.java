package seedu.duke.storage;

import java.io.File;

import seedu.duke.Note;

public class FileEncoder {

    protected File file;
    protected final String separator;

    /**
     * Constructor for the fileEncoder object
     *
     * @param file The file object referring to the .txt file with the raw data.
     * @param separator The <code>String</code> which separates each form of data stored in each <code>Note</code>.
     */
    public FileEncoder (File file, String separator) {
        this.file = file;
        this.separator = separator;
    }

    /**
     *
     * @param name The name of the <code>Note</code>.
     * @param note The <code>Note</code> object processed.
     * @return Returns a processed string.
     */
    public String encodeNote (String name, Note note) {
        return name + separator + note.getPath() + separator + note.getTag();
    }

}
