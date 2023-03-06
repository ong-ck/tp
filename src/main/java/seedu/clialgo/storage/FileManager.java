package seedu.clialgo.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.Scanner;

import seedu.clialgo.Note;

public class FileManager {

    private File file;
    private final FileEncoder encoder;
    private final FileDecoder decoder;
    private final String path;
    private final String folder;
    private final Hashtable<String, String> storedRawData = new Hashtable<>();

    /**
     * Constructor for class containing <code>codeDecoder</code>, <code>codeEncoder</code> and raw data from the
     * .txt file stored as strings.
     */
    public FileManager() {
        this.path = ".\\data\\data.txt";
        this.folder = ".\\data";
        String separator = "&@*";
        this.file = new File(path);
        this.encoder = new FileEncoder(file, separator);
        this.decoder = new FileDecoder(file, separator);
        try {
            readFile();
        } catch (FileNotFoundException e) {
            createFile();
        }
    }

    /**
     * Reads data from the .txt file and stores it in this object.
     *
     * @throws FileNotFoundException Thrown when the .txt file does not exist.
     */
    public void readFile() throws FileNotFoundException {
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            String rawData = s.nextLine();
            decoder.decodeString(rawData);
            storedRawData.put(decoder.decodedName(), rawData);
        }
        s.close();
    }

    /**
     * Creates a folder <code>.\\data</code> if it does not exist. Then, creates a file <code>data.txt</code> in the
     * folder if it does not exist.
     */
    public void createFile() {
        try {
            Path dir = Paths.get(folder);
            Files.createDirectories(dir);
            this.file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Process a <code>Note</code> and add it to the stored data in this object and append the processed
     * <code>Note</code> as a <code>String</code> to the .txt file.
     *
     * @param name The name of the <code>Note</code>.
     * @param note The <code>Note</code> being added.
     */
    public void addEntry (String name, Note note) {
        storedRawData.put(name, encoder.encodeNote(name, note));
        try {
            writeNoteToFile(storedRawData.get(name));
        } catch (IOException e) {
            System.out.println("File write failed");
        }
    }

    /**
     * Deletes entry with <code>key name</code> and rewrite the .txt file.
     *
     * @param name The <code>key</code> of the entry being deleted.
     */
    public void deleteEntry (String name) {
        storedRawData.remove(name);
        try {
            writeAllToFile();
        } catch (IOException e) {
            System.out.println("File write failed");
        }
    }

    /**
     * Deletes all stored raw data in this object and in the .txt file.
     */
    public void deleteAllEntry () {
        storedRawData.clear();
        try {
            writeAllToFile();
        } catch (IOException e) {
            System.out.println("File write failed");
        }
    }

    /**
     * Writes a single <code>Note</code> encoded as a <code>String</code> to the .txt file.
     *
     * @param encodedString The <code>Note</code> encoded as a <code>String</code>.
     * @throws IOException Throws an exception if the file write fails.
     */
    public void writeNoteToFile (String encodedString) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.write(encodedString);
        fw.close();
    }

    /**
     * Writes all the stored raw data into the .txt file, overwriting all the existing data stored in the .txt file.
     *
     * @throws IOException Throws an exception if the file write fails.
     */
    public void writeAllToFile () throws IOException {
        FileWriter fw = new FileWriter(path, false);
        for (String s : storedRawData.values()) {
            fw.write(s);
        }
        fw.close();
    }

    /**
     * Reads all the raw data stored in this object and returns a <code>Hashtable</code> of <code>Notes</code> that is
     * processed.
     *
     * @return Returns the initialized <code>Hashtable</code> of <code>Notes</code>.
     */
    public Hashtable<String, Note> decodeAll() {
        Hashtable<String, Note> decodedNotes = new Hashtable<>();
        for (String s : storedRawData.keySet()) {
            decoder.decodeString(storedRawData.get(s));
            decodedNotes.put(decoder.decodedName(), decoder.processedNote());
        }
        return decodedNotes;
    }
}
