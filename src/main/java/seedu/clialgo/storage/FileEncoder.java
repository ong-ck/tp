package seedu.clialgo.storage;

<<<<<<< HEAD
import seedu.clialgo.file.Code;
import seedu.clialgo.file.Note;
=======
import seedu.clialgo.file.CS2040CFile;
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c

/**
 * Object that takes in a <code>CS2040CFile</code> object and converts it into a <code>String</code> which is then
 * written to the .txt file which the <code>CS2040CFile</code> has the <code>CS2040CFile.tag</code> of.
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
     * Encodes a CS2040CFile into an encoded <code>String</code>.
     *
     * @param name The name of the <code>CS2040CFile</code>.
     * @param cs2040cFile The <code>CS2040CFile</code> object processed.
     * @return Returns a processed string.
     */
<<<<<<< HEAD
    public String encodeNote (String name, Note note) {
        return "N" + separator + name + separator + note.getPath() + separator + note.getTopic() + separator +
                note.getImportance();
    }

    public String encodeCode (String name, Code code) {
        return "C" + separator + name + separator + code.getPath() + separator + code.getTopic() + separator +
                code.getImportance();
=======
    public String encodeCS2040CFile(String name, CS2040CFile cs2040cFile) {
        return name + separator + cs2040cFile.getPath() + separator + cs2040cFile.getTopic();
>>>>>>> 0717b1fe83fb6feaa55537d9ac0fdd5e4edf2a2c
    }

}
