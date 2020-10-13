package seedu.duke.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Portfolio implements Serializable {
    HashMap<String, Stock> stocks;

    public Portfolio() {
        stocks = new HashMap<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void sellStock(Stock stock) {
        stocks.remove(stock);
    }
}
