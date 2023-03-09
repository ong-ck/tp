package seedu.clialgo.storage;

import seedu.clialgo.Note;

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
     * <code>Note</code> and the <code>Note</code> itself in this object.
     *
     * @param encodedNote The encoded <code>String</code> that represents a <code>Note</code>.
     */
    public void decodeString (String encodedNote) {
        try {
            String[] splitNote = encodedNote.split(separator);
            this.currentName = splitNote[0];
            currentNote = new Note(this.currentName, splitNote[1], splitNote[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid note");
        }
    }

    public String decodedName () {
        return currentName;
    }

    public Note processedNote () {
        return currentNote;
    }
}
