package seedu.duke.command;

import seedu.duke.data.StockList;
import seedu.duke.data.exception.DukeException;

import java.nio.file.Path;

public abstract class Command {

    public abstract void executeCommand(String userInput, StockList stocks) throws DukeException;

}
