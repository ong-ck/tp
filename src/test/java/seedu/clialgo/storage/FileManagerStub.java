package seedu.clialgo.storage;

import seedu.clialgo.Topic;
import seedu.clialgo.file.CS2040CFile;
import seedu.clialgo.file.Code;
import seedu.clialgo.file.Note;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FileManagerStub {
    private HashMap<String, Topic> topics;
    private HashSet<String> allLabelledCS2040CFileNames;

    public FileManagerStub() {
        HashMap<String, CS2040CFile> sortingCS2040CFiles = new HashMap<>(
                Map.of(
                        "Bubble Sort Note",
                        new Note("Bubble Sort Note", "Bubble Sort Note.txt", "SORTING", 5),
                        "Merge Sort Code",
                        new Code("Merge Sort Code", "Merge Sort Code.cpp", "SORTING", 8),
                        "Quick Sort Note",
                        new Note("Quick Sort Note", "Quick Sort Note.txt", "SORTING", 3)
                )
        );
        Topic sortingTopic = new Topic("SORTING", sortingCS2040CFiles);

        HashMap<String, CS2040CFile> binaryHeapCS2040CFiles = new HashMap<>(
                Map.of(
                        "BST Note",
                        new Note("BST Note", "BST Note.txt", "BINARY_HEAP", 5),
                        "AVL Code",
                        new Code("AVL Code", "AVL Code.cpp", "BINARY_HEAP", 8)
                )
        );
        Topic binaryHeapTopic = new Topic("BINARY_HEAP", binaryHeapCS2040CFiles);

        HashMap<String, CS2040CFile> shortestPathCS2040CFiles = new HashMap<>(
                Map.of(
                        "Bellman Ford Note",
                        new Note("Bellman Ford Note", "Bellman Ford Note.txt", "SS_SHORTEST_PATH",
                                5),
                        "Dijkstra Code",
                        new Code("Dijkstra Code", "Dijkstra Code.cpp", "SS_SHORTEST_PATH", 8)
                )
        );
        Topic shortestPathTopic = new Topic("SS_SHORTEST_PATH", shortestPathCS2040CFiles);

        this.topics = new HashMap<>();
        this.topics.put("SORTING", sortingTopic);
        this.topics.put("BINARY_HEAP", binaryHeapTopic);
        this.topics.put("SS_SHORTEST_PATH", shortestPathTopic);

        this.allLabelledCS2040CFileNames = new HashSet<>(
                Arrays.asList(
                        "[NOTE] Bubble Sort Note", "[CODE] Merge Sort Code", "[NOTE] Quick Sort Note",
                        "[NOTE] BST Note", "[CODE] AVL Code", "[NOTE] Bellman Ford Note", "[CODE] Dijkstra Code"
                )
        );
    }

    public HashMap<String, Topic> decodeAll() {
        return this.topics;
    }

    public boolean isPresent(String labelledCS2040CFileName) {
        return allLabelledCS2040CFileNames.contains(labelledCS2040CFileName);
    }
}
