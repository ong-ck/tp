package seedu.clialgo;

import seedu.clialgo.command.Command;
import seedu.clialgo.storage.FileManager;

import java.util.Scanner;

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
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
    }
}
