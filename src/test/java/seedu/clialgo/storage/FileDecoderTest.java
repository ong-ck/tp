package seedu.clialgo.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.clialgo.file.Code;
import seedu.clialgo.file.Note;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileDecoderTest {
    private FileDecoder fileDecoder;
    private final String separator = "@&";
    private final String name = "name";
    private final String topic = "topic";
    private final int importance = 1;

    @BeforeEach
    public void setUp() {
        fileDecoder = new FileDecoder(separator);
    }

    @Test
    void isCorrectNoteCreated_expectTrue() {
        String path = name + ".txt";
        String pathToFile = ".\\" + path;
        File file = new File(pathToFile);
        try {
            if (!file.createNewFile()) {
                System.out.println("ERROR 1");
            }
            Note note = new Note(name, path,topic, 1);
            String encodedString = name + separator + path + separator + topic + separator + importance;
            System.out.println(encodedString);
            fileDecoder.decodeString(encodedString, topic);
            assertEquals(note, fileDecoder.processedCS2040CFile());
            if (!file.delete()) {
                System.out.println("ERROR 2");
            }
        } catch (IOException e) {
            System.out.println("ERROR 3");
        }
    }

    @Test
    void isCorrectCodeCreated_expectTrue() {
        String path = name + ".cpp";
        String pathToFile = ".\\" + path;
        File file = new File(pathToFile);
        try {
            if (!file.createNewFile()) {
                System.out.println("ERROR 1");
            }
            Code code = new Code(name, path,topic, 1);
            String encodedString = name + separator + path + separator + topic + separator + importance;
            System.out.println(encodedString);
            fileDecoder.decodeString(encodedString, topic);
            assertEquals(code, fileDecoder.processedCS2040CFile());
            if (!file.delete()) {
                System.out.println("ERROR 2");
            }
        } catch (IOException e) {
            System.out.println("ERROR 3");
        }
    }


}
