package seedu.duke.command;

import seedu.duke.api.Api;
import seedu.duke.data.StockList;
import seedu.duke.data.exception.DukeException;
import seedu.duke.parser.Parser;

public class SearchCommand extends Command {

    @Override
    public void executeCommand(String userInput, StockList stocks) throws DukeException {
        String symbol = Parser.getSearch(userInput);

    }
}
