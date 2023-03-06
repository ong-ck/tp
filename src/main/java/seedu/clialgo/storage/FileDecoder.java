package seedu.clialgo.storage;

import java.io.File;

import seedu.clialgo.Note;

public class FileDecoder {

    protected File file;
    protected Note currentNote;
    protected String currentName;
    protected final String separator;

    /**
     * Constructor for the fileDecoder object
     *
     * @param file The file object referring to the .txt file with the raw data.
     * @param separator The <code>String</code> which separates each form of data stored in each <code>Note</code>.
     */
    public FileDecoder (File file, String separator) {
        this.file = file;
        this.separator = separator;
    }

    /**
     * Converts an encoded <code>Note</code> from a <code>String</code> and stores the name of the
     * <code>Note</code> and the <code>Note</code> itself in this object.
     *
     * @param encodedNote The encoded <code>String</code> that represents a <code>Note</code>.
     */
    public void decodeString (String encodedNote) {
        String[] temp = encodedNote.split(separator);
        temp[0] = currentName;
        currentNote = new Note(currentName, temp[1], temp[2]);
    }

    public String decodedName () {
        return currentName;
    }

    public Note processedNote () {
        return currentNote;
    }

}
