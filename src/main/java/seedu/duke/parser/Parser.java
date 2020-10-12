package seedu.duke.parser;

import seedu.duke.command.ByeCommand;
import seedu.duke.command.Command;
import seedu.duke.command.SearchCommand;
import seedu.duke.data.exception.DukeException;

public class Parser {

    public static Command parseCommand(String userInput) throws DukeException {
        Command command;
        if (userInput.contains("search")) {
            command = new SearchCommand();
        } else if (userInput.contains("bye")) {
            command = new ByeCommand();
        } else {
            throw new DukeException("Command does not exist! Try Again.");
        }
        return command;
    }

    public static String getSearch(String userInput) throws DukeException {
        String symbol;
        try {
            symbol = userInput.substring("search".length() + 1);
        } catch (Exception e) {
            throw new DukeException("Search input cannot be empty!");
        }
        return symbol;
    }
}
