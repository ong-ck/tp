package seedu.clialgo.storage;

import seedu.clialgo.file.Note;
import seedu.clialgo.Ui;

/**
 * Object that processes a <code>String</code> passed to it and returns a <code>Note</code> representing the
 * information in the <code>String</code>.
 */
public class FileDecoder {
    protected Note currentNote;
    protected String currentName;
    protected final String separator;

    /**
     * Constructor for the fileDecoder object
     *
     * @param separator The <code>String</code> which separates each form of data stored in each <code>Note</code>.
     */
    public FileDecoder (String separator) {
        this.separator = separator;
    }

    /**
     * Converts an encoded <code>Note</code> from a <code>String</code> and stores the name of the
     * <code>Note</code> and the <code>Note</code> itself in this object. If there are any missing or corrupted fields,
     * the <code>Note</code> object is deemed corrupted.
     *
     * @param encodedNote The encoded <code>String</code> that represents a <code>Note</code>.
     * @return true if there are any wrong entries or <code>isCorrupted</code> otherwise.
     */
    public boolean decodeString (String encodedNote, String topicName) {
        try {
            String[] splitNote = encodedNote.split(separator, 3);
            if (!splitNote[2].equals(topicName)) {
                return true;
            }
            this.currentName = splitNote[0];
            currentNote = new Note(this.currentName, splitNote[1], splitNote[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        return false;
    }

    public String decodedName () {
        return currentName;
    }

    public Note processedNote () {
        return currentNote;
    }
}
