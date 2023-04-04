package seedu.clialgo.storage;

import org.junit.jupiter.api.Test;
import seedu.clialgo.Topic;
import seedu.clialgo.file.Code;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileManagerTest {

    private final String path = ".\\testdata";

    /**
     * Deletes folder at <code>pathToFolder</code> and all the files within.
     * @param pathToFolder The <code>File</code> representing the folder to delete.
     */
    public void deleteAll(File pathToFolder) {
        File[] files = pathToFolder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (!f.delete()) {
                    System.out.println("Delete failed");
                } else {
                    System.out.println("Delete success");
                }
            }
        }
        if (!pathToFolder.delete()) {
            System.out.println("Delete failed");
        } else {
            System.out.println("Delete successful");
        }
    }

    /**
     * Test if folder is created correctly when <code>initialize</code> is called from a <code>FileManager</code>
     * object.
     */
    @Test
    void isFolderCorrectlyCreated_noInput_expectTrue() {
        ArrayList<String> test = new ArrayList<>();
        FileManager fm = new FileManager(path, test);
        fm.initialize();
        File file = new File(path);
        assertTrue(file.exists());
        deleteAll(file);
    }

    /**
     * Test if a single .txt <code>File</code> is created correctly when <code>initialize</code>
     * is called from a <code>FileManager</code> object.
     */
    @Test
    void isOneFileCorrectlyCreated_oneInput_expectTrue() {
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        FileManager fm = new FileManager(path, test);
        fm.initialize();
        File file = new File(path + "\\test.txt");
        assertTrue(file.exists());
        deleteAll(new File(path));
    }

    /**
     * Test if a multiple .txt <code>Files</code> are created correctly when <code>initialize</code>
     * is called from a <code>FileManager</code> object.
     */
    @Test
    void areMultipleFilesCorrectlyCreated_multipleInputs_expectTrue() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("test1", "test2"));
        FileManager fm = new FileManager(path, test);
        fm.initialize();
        for (String s : test) {
            File file = new File(path + "\\" + s + ".txt");
            assertTrue(file.exists());
        }
        deleteAll(new File(path));
    }

    /** Test if a <code>HashMap</code> with the correctly named <code>keys</code> is created. */
    @Test
    void areCorrectKeysWhenDecodeAll_multipleInputs_expectTrue() {
        ArrayList<String> test = new ArrayList<>(Arrays.asList("test1", "test2"));
        FileManager fm = new FileManager(path, test);
        fm.initialize();
        HashMap<String, Topic> testOutput = fm.decodeAll();
        for (String s: test) {
            assertNotNull(testOutput.get(s));
        }
        deleteAll(new File(path));
    }

    @Test
    void doesAddEntryThrowIOException_expectFalse() {
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        FileManager fm = new FileManager(path, test);
        fm.initialize();
        deleteAll(new File(path));
        Code file = new Code("name", "path", "test");
        boolean isSuccessful = fm.addEntry("name", file);
        assertFalse(isSuccessful);
        deleteAll(new File(path));
    }

    @Test
    void doesDeleteEntryThrowIOException_expectFalse() {
        ArrayList<String> test = new ArrayList<>();
        test.add("test");
        FileManager fm = new FileManager(path, test);
        fm.initialize();
        Code file = new Code("name", "path", "test");
        fm.addEntry("name", file);
        deleteAll(new File(path));
        boolean isSuccessful = fm.deleteEntry("name", "test");
        assertFalse(isSuccessful);
        deleteAll(new File(path));
    }
}
