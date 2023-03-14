package seedu.clialgo.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.clialgo.Parser;
import seedu.clialgo.TopicManager;
import seedu.clialgo.Ui;
import seedu.clialgo.storage.FileManager;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;

public class ListCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private Ui ui;
    private TopicManager topicManager;
    private Parser parser;
    private FileManager fileManager;

    /**
     * Deletes folder at <code>pathToFolder</code> and all the files within.
     * @param pathToFolder The <code>File</code> representing the folder to delete.
     */
    public void deleteAll(File pathToFolder) {
        for (File f : Objects.requireNonNull(pathToFolder.listFiles())) {
            if (!f.delete()) {
                System.out.println("Delete failed");
            }
        }
        if (!pathToFolder.delete()) {
            System.out.println("Delete failed");
        } else {
            System.out.println("Delete successful");
        }
    }

    /**
     * Runs before each test, initializes  <code>Ui</code>, <code>TopicManager</code>, <code>Parser</code> and
     * <code>FileManager</code>.
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
        parser = new Parser();
        topicManager = new TopicManager();
        ui = new Ui();
        fileManager = new FileManager(".\\testdata", new ArrayList<>());
    }

    @Test
    void isEmptyCheck_expectTrue() {

    }
}

