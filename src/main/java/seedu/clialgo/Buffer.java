package seedu.clialgo;

import seedu.clialgo.file.Code;

import seedu.clialgo.file.Note;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Objects;

public class Buffer {

    private Buffer buffer = null;
    private ArrayList<Note> notes;
    private ArrayList<Code> codes;
    private final File pathToBuffer;
    private final Ui ui;

    private Buffer() {
        this.notes = new ArrayList<>();
        this.codes = new ArrayList<>();
        this.ui = new Ui();
        this.pathToBuffer = new File(".\\export");
        createFolder();
    }

    public Buffer getInstance() {
        if (buffer == null) {
            buffer = new Buffer();
        }
        return buffer;
    }

    private void createFolder() {
        if (!pathToBuffer.mkdir()) {
            ui.printFolderCreateError();
        }
    }

    public void clearBuffer() {
        notes.clear();
        codes.clear();
        deleteFiles();
    }

    public void deleteFiles() {
        for (File file : Objects.requireNonNull(pathToBuffer.listFiles())) {
            if (!file.delete()) {
                ui.printFileDeleteFail();
            }
        }
    }

    public void updateBuffer() {
        clearBuffer();
    }

    public void addFilesToBuffer() {
        for (Note note: notes) {
            Path target = Paths.get(pathToBuffer + note.getName() + ".txt");
            Path source = Paths.get(note.getPath());
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                ui.printFileWriteError();
            }
        }
        for (Code code: codes) {
            Path target = Paths.get(pathToBuffer + code.getName() + ".txt");
            Path source = Paths.get(code.getPath());
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                ui.printFileWriteError();
            }
        }
    }

    public void exportBuffer() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(pathToBuffer);
        } catch (IllegalArgumentException | IOException e) {
            ui.printInvalidCommand();
        }
    }
}
