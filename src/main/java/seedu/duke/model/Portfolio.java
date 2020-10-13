package seedu.duke.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Portfolio implements Serializable {
    ArrayList<Stock> stocks;

    public Portfolio() {
        stocks = new ArrayList<>();
    }
}
