package seedu.clialgo.storage;

import seedu.clialgo.Note;
import seedu.clialgo.Topic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class FileManager {

    private final FileEncoder encoder;
    private final FileDecoder decoder;
    private final String path;
    private final ArrayList<String> topicNames;
    private final HashMap<String, SingleFile> topicRawData;

    /**
     * Constructor for class containing <code>codeDecoder</code>, <code>codeEncoder</code> and raw data from the
     * .txt file stored as strings.
     */
    public FileManager(String path, ArrayList<String> topicNames) {
        this.path = path;
        String separator = "&@*";
        this.topicRawData = new HashMap<>();
        this.topicNames = topicNames;
        this.encoder = new FileEncoder(separator);
        this.decoder = new FileDecoder(separator);
    }

    /**
     * Creates a <code>SingleFile</code> object and creates a .txt file if the .txt does not exist.
     *
     * @param name Name of the .txt file.
     * @return The SingleFile object created.
     */
    public SingleFile createSingleFile(String name) {
        File file = new File(path + "\\" + name + ".txt");
        SingleFile newFile = new SingleFile(file, name, decoder);
        try {
            if (file.createNewFile()) {
                newFile.setFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * Creates all the <code>SingleFiles</code> corresponding to each valid <code>Topic</code>. If the .txt file does
     * not exist, it creates a blank .txt file with <code>topicNames</code>.txt. For all the <code>SingleFiles</code>,
     * reads the <code>File</code> corresponding to it.
     */
    public void initialize() {
        createFolder();
        for (String s : topicNames) {
            topicRawData.put(s, createSingleFile(s));
        }
        for (SingleFile singleFile : topicRawData.values()) {
            try {
                singleFile.readFile();
            } catch (FileNotFoundException e) {
                System.out.println("File write error");
            }
        }
    }

    /**
     * Creates a folder at <code>path</code>.
     */
    public void createFolder() {
        try {
            Path dir = Paths.get(path);
            Files.createDirectories(dir);
        } catch (IOException e) {
            System.out.println("Folder not created");
        }
    }

    /**
     * Process a <code>Note</code> and add it to the stored data in the <code>SingleFile</code> object and append the
     * processed <code>Note</code> as a <code>String</code> to the .txt file.
     *
     * @param name The name of the note.
     * @param note The <code>Note</code> being added.
     */
    public void addEntry (String name, Note note) {
        SingleFile singleFile = topicRawData.get(note.getTag());
        try {
            singleFile.writeNoteToFile(encoder.encodeNote(name ,note));
        } catch (IOException e) {
            System.out.println("File write error");
        }
    }

    /**
     * Deletes <code>Note</code> with <code>noteName</code> in <code>topicName</code>.txt and rewrite the .txt file.
     *
     * @param noteName The name of the <code>Note</code> being deleted.
     */
    public void deleteEntry (String noteName) {
        for (SingleFile sf : topicRawData.values()) {
            sf.deleteEntry(noteName);
        }
    }

    /**
     * Deletes all stored raw data in <code>topicName</code>.txt.
     *
     * @param topicName The name of the .txt file being emptied.
     */
    public void deleteAllEntry (String topicName) {
        topicRawData.get(topicName).clearFile();
    }

    /**
     * Reads all the raw data stored in this object and returns a <code>HashMap</code> of <code>Topics</code> that is
     * processed.
     *
     * @return Returns the initialized <code>HashMap</code> of <code>Notes</code>.
     */
    public HashMap<String, Topic> decodeAll() {
        HashMap<String, Topic> topics = new HashMap<>();
        for (String s: topicRawData.keySet()) {
            topics.put(s, topicRawData.get(s).convertFileToTopic());
        }
        return topics;
    }
}
