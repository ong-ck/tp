package seedu.clialgo.storage;

import seedu.clialgo.Note;
import seedu.clialgo.Topic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SingleFile {

    private File file;
    private final String name;
    private final HashMap<String, String> storedRawData = new HashMap<>();
    private final HashMap<String, Note> notes = new HashMap<>();
    private final FileDecoder decoder;


    public SingleFile (File file, String name, FileDecoder decoder) {
        this.file = file;
        this.name = name;
        this.decoder = decoder;
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
            notes.put(decoder.decodedName(), decoder.processedNote());
        }
        s.close();
    }

    /**
     * Writes a single <code>Note</code> encoded as a <code>String</code> to the .txt file.
     *
     * @param encodedNote The <code>Note</code> encoded as a <code>String</code>.
     * @throws IOException Throws an exception if the file write fails.
     */
    public void writeNoteToFile(String encodedNote) throws IOException {
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(encodedNote);
            fw.close();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * Writes all the stored raw data into the .txt file, overwriting all the existing data stored in the .txt file.
     *
     * @throws IOException Throws an exception if the file write fails.
     */
    public void overwriteFile() throws IOException {
        try {
            FileWriter fw = new FileWriter(file, false);
            for (String s : storedRawData.values()) {
                fw.write(s);
            }
            fw.close();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    public void deleteEntry(String name) {
        storedRawData.remove(name);
        try {
            overwriteFile();
        } catch (IOException e) {
            System.out.println("File write fail");
        }
    }

    public Topic convertFileToTopic () {
        return new Topic(name, notes);
    }

    public void clearFile() {
        storedRawData.clear();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
