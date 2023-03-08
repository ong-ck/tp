package seedu.clialgo;

import seedu.clialgo.command.Command;
import seedu.clialgo.storage.FileManager;

public class CLIAlgo {
    private Ui ui;
    private TopicManager topicManager;
    private FileManager fileManager;
    private Parser parser;
    public CLIAlgo() {
        ui = new Ui();
        topicManager = new TopicManager();
        fileManager = new FileManager();
        parser = new Parser();
        ui.printWelcomeMessage();
    }

    /** Continuously reads in the user input until the exit command is executed */
    private void run() {
        while (true) {
            String fullCommand = ui.getUserInput();
            Command command = parser.parse(fullCommand, topicManager);
            command.execute(topicManager, ui, fileManager);
        }
    }

    public static void main(String[] args) {
        CLIAlgo cliAlgo = new CLIAlgo();
        cliAlgo.run();
    }
}
