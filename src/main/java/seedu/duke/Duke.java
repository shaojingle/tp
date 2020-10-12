package seedu.duke;

import seedu.duke.api.Api;
import seedu.duke.command.Command;
import seedu.duke.data.StockList;
import seedu.duke.data.exception.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Duke {

    public final Ui ui;
    // private final Storage storage;
    private StockList stocks;

    public Duke() {
        ui = new Ui();
        ui.greetUser();
        
        stocks = new StockList();
    }

    /**
     * Runs Duke program
     */
    public void run() {
        boolean isBye = false;
        while (!isBye) {
            try {
                String userInput = Ui.getUserInput();
                Command command = Parser.parseCommand(userInput);
                command.executeCommand(userInput, stocks);
                isBye = ui.sayBye(userInput);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("================================================");
            } catch (DukeException | InterruptedException e) {
                ui.showErrorMessage(e.getMessage());
                System.out.println("================================================");
            }
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {

        final Api api;
        try {
            api = new Api();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // new Duke().run();


    }


}
