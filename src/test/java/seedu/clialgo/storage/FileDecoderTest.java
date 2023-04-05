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
    private final String SEPARATOR = "@&";
    private final String NAME = "name";
    private final String TOPIC = "topic";
    private final String CURRENT_DIRECTORY_PATH = ".\\";
    private final int IMPORTANCE = 1;

    @BeforeEach
    public void setUp() {
        fileDecoder = new FileDecoder(SEPARATOR);
    }

    @Test
    void isCorrectNoteCreated_expectTrue() {
        String noteFileExtension = ".txt";
        String path = NAME + noteFileExtension;
        String pathToFile = CURRENT_DIRECTORY_PATH + path;
        File file = new File(pathToFile);
        try {
            if (!file.createNewFile()) {
                System.out.println("ERROR 1");
            }
            Note note = new Note(NAME, path,TOPIC, 1);
            String encodedString = NAME + SEPARATOR + path + SEPARATOR + TOPIC + SEPARATOR + IMPORTANCE;
            System.out.println(encodedString);
            fileDecoder.decodeString(encodedString, TOPIC);
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
        String codeFileExtension = ".cpp";
        String path = NAME + codeFileExtension;
        String pathToFile = CURRENT_DIRECTORY_PATH + path;
        File file = new File(pathToFile);
        try {
            if (!file.createNewFile()) {
                System.out.println("ERROR 1");
            }
            Code code = new Code(NAME, path,TOPIC, 1);
            String encodedString = NAME + SEPARATOR + path + SEPARATOR + TOPIC + SEPARATOR + IMPORTANCE;
            System.out.println(encodedString);
            fileDecoder.decodeString(encodedString, TOPIC);
            assertEquals(code, fileDecoder.processedCS2040CFile());
            if (!file.delete()) {
                System.out.println("ERROR 2");
            }
        } catch (IOException e) {
            System.out.println("ERROR 3");
        }
    }

}
