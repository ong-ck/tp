package seedu.clialgo;

import seedu.clialgo.file.CS2040CFile;

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

    private static Buffer buffer = null;
    private final ArrayList<CS2040CFile> files;
    private final File pathToBuffer;
    private final Ui ui;

    private Buffer() {
        this.files = new ArrayList<>();
        this.ui = new Ui();
        this.pathToBuffer = new File(".\\export");
        createFolder();
    }

    public static Buffer getInstance() {
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

    public boolean isEmpty() {
        return this.files.isEmpty();
    }

    public void deleteFiles() {
        for (File file : Objects.requireNonNull(pathToBuffer.listFiles())) {
            if (!file.delete()) {
                ui.printFileDeleteFail();
            }
        }
    }

    public void updateBuffer(ArrayList<CS2040CFile> filteredFiles) {
        this.files.clear();
        deleteFiles();
        this.files.addAll(filteredFiles);
    }

    public void addFilesToBuffer() {
        for (CS2040CFile file: this.files) {
            Path source = Paths.get(".\\" + file.getPath());
            Path target = Paths.get(this.pathToBuffer + "\\" + file.getPath());
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                ui.printFileWriteError();
            }
        }
    }

    public void exportBuffer() {
        deleteFiles();
        addFilesToBuffer();
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(this.pathToBuffer);
        } catch (IllegalArgumentException | IOException e) {
            this.ui.printInvalidCommand();
        }
    }
}
