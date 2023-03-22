package seedu.clialgo.storage;

<<<<<<< HEAD
import seedu.clialgo.file.Code;
=======
//import seedu.clialgo.file.Note;
import seedu.clialgo.FileType;
import seedu.clialgo.file.Code;
import seedu.clialgo.file.CS2040CFile;
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
import seedu.clialgo.file.Note;

/**
 * Object that processes a <code>String</code> passed to it and returns a <code>CS2040CFile</code> representing the
 * information in the <code>String</code>.
 */
public class FileDecoder {
<<<<<<< HEAD
    protected Note currentNote;
    protected Code currentCode;
=======
    protected CS2040CFile currentCS2040CFile;
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
    protected String currentName;
    protected final String separator;

    /**
     * Constructor for the fileDecoder object
     *
     * @param separator The <code>String</code> which separates each form of data stored in each <code>File</code>.
     */
    public FileDecoder (String separator) {
        this.separator = separator;
    }

    public FileType checkFileType() {
        String pathInTxt = this.currentName + ".txt";
        String pathInCpp = this.currentName + ".cpp";

        if (new java.io.File(".\\" + pathInTxt).isFile()) {
            return FileType.TXT;
        } else if (new java.io.File(".\\" + pathInCpp).isFile()) {
            return FileType.CPP;
        } else {
            return FileType.DOESNOTEXIST;
        }
    }

    /**
     * Converts an encoded <code>CS2040CFile</code> from a <code>String</code> and stores the name of the
     * <code>CS2040CFile</code> and the <code>CS2040CFile</code> itself in this object. If there are any missing or
     * corrupted fields, the <code>CS2040CFile</code> object is deemed corrupted.
     *
     * @param encodedCS2040CFile The encoded <code>String</code> that represents a <code>CS2040CFile</code>.
     * @return true if there are any wrong entries or <code>isCorrupted</code> otherwise.
     */
    public boolean decodeString (String encodedCS2040CFile, String topicName) {
        try {
<<<<<<< HEAD
            String[] splitNote = encodedNote.split(separator, 5);
            if (!splitNote[3].equals(topicName)) {
                return true;
            }
            this.currentName = splitNote[1];
            if (splitNote[0].equals("N")) {
                currentNote = new Note(this.currentName, splitNote[2], splitNote[3], Integer.parseInt(splitNote[4]));
                currentCode = null;
            } else if (splitNote[0].equals("C")) {
                currentCode = new Code(this.currentName, splitNote[2], splitNote[3], Integer.parseInt(splitNote[4]));
                currentNote = null;
            } else {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
=======
            String[] splitCS2040CFile = encodedCS2040CFile.split(separator, 3);
            if (!splitCS2040CFile[2].equals(topicName)) {
                return true;
            }
            this.currentName = splitCS2040CFile[0];
            if (checkFileType() == FileType.CPP) {
                currentCS2040CFile = new Code(this.currentName, splitCS2040CFile[1], splitCS2040CFile[2]);
            } else {
                currentCS2040CFile = new Note(this.currentName, splitCS2040CFile[1], splitCS2040CFile[2]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
            return true;
        }
        return false;
    }

    public String decodedName () {
        return currentName;
    }

    public CS2040CFile processedCS2040CFile() {
        return currentCS2040CFile;
    }

    public Code processedCode() {
        return currentCode;
    }
}
