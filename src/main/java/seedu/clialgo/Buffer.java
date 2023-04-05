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

/**
 * The <code>Buffer</code> contains the <code>CS2040CFiles</code> that are returned after <code>FilterCommand</code>
 * and it's derivatives or <code>TopoCommand</code> is executed. The stored <code>CS2040CFiles</code> can be exported
 * through executing <code>ExportCommand</code>.
 */
public class Buffer {

    private static Buffer buffer = null;
    private final ArrayList<CS2040CFile> files;
    private final File pathToBuffer;
    private final Ui ui;

    /**
     * This is a private constructor for a Singleton-type object as only one <code>Buffer</code> would be instantiated.
     */
    private Buffer() {
        this.files = new ArrayList<>();
        this.ui = new Ui();
        this.pathToBuffer = new File(".\\export");
        createFolder();
    }

    /**
     * This static function returns the same <code>Buffer</code> object whenever there is an attempt to instantiate
     * a <code>Buffer</code> object.
     *
     * @return The Singleton <code>Buffer</code> object.
     */
    public static Buffer getInstance() {
        if (buffer == null) {
            buffer = new Buffer();
        }
        return buffer;
    }

    private void createFolder() {
        try {
            Files.createDirectories(pathToBuffer.toPath());
        } catch (IOException e) {
            ui.printFolderCreateError();
        }
    }

    public boolean isEmpty() {
        return this.files.isEmpty();
    }

    /**
     * Deletes all the files in <code>.\\export</code>.
     */
    public void deleteFiles() {
        File[] files = pathToBuffer.listFiles();
        if (files != null) {
            for (File file : files) {
                assert file.exists() : "This should be non-null";
                if (!file.delete()) {
                    ui.printFileDeleteFail();
                }
            }
        }
    }

    /**
     * This function is called whenever <code>FilterCommand</code> or it's derivatives or <code>TopoCommand</code>
     * is executed. The <code>CS2040CFiles</code> objects that are returned in those <code>Commands</code> replaces the
     * <code>CS2040CFiles</code> objects previously stored in this object.
     *
     * @param filteredFiles The new <code>CS2040CFiles</code> objects to be stored in this object.
     */
    public void updateBuffer(ArrayList<CS2040CFile> filteredFiles) {
        this.files.clear();
        deleteFiles();
        this.files.addAll(filteredFiles);
    }

    /**
     * Copies the <code>CS2040CFiles</code> objects to the <code>.\\export</code> folder. Prints an error message
     * if the copy fails.
     */
    public void addFilesToBuffer() {
        for (CS2040CFile file: this.files) {
            Path source = Paths.get(".\\" + file.getPath());
            Path target = Paths.get(this.pathToBuffer + "\\" + file.getPath());
            try {
                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                ui.printFileMissing();
            }
        }
    }

    /**
     * Deletes all the <code>CS2040CFiles</code> previously stored in <code>.\\export</code> before copying the
     * <code>CS2040CFiles</code> objects stored in this object into <code>.\\export</code>. <code>.\\export</code>
     * is then opened if a file explorer application is available to use.
     */
    public void exportBuffer() {
        deleteFiles();
        addFilesToBuffer();
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(this.pathToBuffer);
        } catch (IOException | IllegalArgumentException e) {
            createFolder();
            ui.printFolderMissing();
        } catch (UnsupportedOperationException e) {
            ui.printOpenFolderNotSupported();
        }
    }
}
