package seedu.clialgo.storage;

import seedu.clialgo.Topic;
import seedu.clialgo.Ui;
import seedu.clialgo.file.CS2040CFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SingleFile {

    private java.io.File file;
    private final String name;
    private final Ui ui;
    private final HashMap<String, String> storedRawData = new HashMap<>();
    private final HashMap<String, CS2040CFile> cs2040cFiles = new HashMap<>();
    private final FileDecoder decoder;


    public SingleFile (java.io.File file, String name, FileDecoder decoder) {
        this.file = file;
        this.name = name;
        this.ui = new Ui();
        this.decoder = decoder;
    }

    /**
     * Reads data from the .txt file and stores it in this object. If the file is corrupted, after reading in the
     * non-corrupted data, overwrites the data file with the non-corrupted data while purging the corrupted data.
     *
     * @throws FileNotFoundException Thrown when the .txt file does not exist.
     */
    public void readFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        boolean isFileCorrupted = false;
        while (scanner.hasNext()) {
            String rawData = scanner.nextLine();
            boolean isCorrupted = decoder.decodeString(rawData, name);
            if (!isCorrupted) {
                storedRawData.put(decoder.decodedName(), rawData);
                cs2040cFiles.put(decoder.decodedName(), decoder.processedCS2040CFile());
            } else {
                isFileCorrupted = true;
            }
        }
        scanner.close();
        if (isFileCorrupted) {
            try {
                overwriteFile();
            } catch (IOException e) {
                ui.printFileWriteError();
            }
        }
    }

    /**
     * Writes a single <code>CS2040CFile</code> encoded as a <code>String</code> to the .txt file.
     * If the file does not exist
     * during method call, recreate the file with <code>recreateFile</code>.
     *
     * @param encodedCS2040CFile The <code>CS2040CFile</code> encoded as a <code>String</code>.
     * @throws IOException Throws an exception if the file write fails.
     */
    public void writeCS2040CFileToFile(String encodedCS2040CFile) throws IOException {
        assert encodedCS2040CFile != null : "Empty string";
        try {
            if (!file.exists()) {
                recreateFile();
                overwriteFile();
            }
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(encodedCS2040CFile + "\n");
            fileWriter.close();
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
            FileWriter fileWriter = new FileWriter(file, false);
            for (String s : storedRawData.values()) {
                fileWriter.write(s);
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new IOException();
        }
    }

    /**
     * Deletes a single <code>CS2040CFile</code> and updates the .txt file. If the file does not exist
     * during method call, recreate the file with <code>recreateFile</code>.
     *
     * @param name The name of the <code>CS2040CFile</code> being deleted.
     * @throws IOException Throws an exception if the file write fails.
     */
    public void deleteEntry(String name) throws IOException{
        if (storedRawData.remove(name) != null) {
            try {
                if (!file.exists()) {
                    recreateFile();
                }
                overwriteFile();
            } catch (IOException e) {
                throw new IOException();
            }
            cs2040cFiles.remove(name);
        }
    }

    /**
     * Recreates the data file with all the entries reset based on the current data stored in this object.
     */
    public void recreateFile() {
        try {
            if (file.createNewFile()) {
                overwriteFile();
                ui.printFileRecreatedSuccess();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Topic convertFileToTopic () {
        return new Topic(name, cs2040cFiles);
    }

    public void clearFile() {
        storedRawData.clear();
    }

    public void setFile(File file) {
        this.file = file;
    }
}
