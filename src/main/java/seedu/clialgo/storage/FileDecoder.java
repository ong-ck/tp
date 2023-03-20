package seedu.clialgo.storage;

//import seedu.clialgo.file.Note;
import seedu.clialgo.FileType;
import seedu.clialgo.file.Code;
import seedu.clialgo.file.File;
import seedu.clialgo.file.Note;

/**
 * Object that processes a <code>String</code> passed to it and returns a <code>File</code> representing the
 * information in the <code>String</code>.
 */
public class FileDecoder {
    protected File currentFile;
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
     * Converts an encoded <code>File</code> from a <code>String</code> and stores the name of the
     * <code>File</code> and the <code>File</code> itself in this object. If there are any missing or corrupted fields,
     * the <code>File</code> object is deemed corrupted.
     *
     * @param encodedFile The encoded <code>String</code> that represents a <code>File</code>.
     * @return true if there are any wrong entries or <code>isCorrupted</code> otherwise.
     */
    public boolean decodeString (String encodedFile, String topicName) {
        try {
            String[] splitFile = encodedFile.split(separator, 3);
            if (!splitFile[2].equals(topicName)) {
                return true;
            }
            this.currentName = splitFile[0];
            if (checkFileType() == FileType.CPP) {
                currentFile = new Code(this.currentName, splitFile[1], splitFile[2]);
            } else {
                currentFile = new Note(this.currentName, splitFile[1], splitFile[2]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        return false;
    }

    public String decodedName () {
        return currentName;
    }

    public File processedFile () {
        return currentFile;
    }
}
