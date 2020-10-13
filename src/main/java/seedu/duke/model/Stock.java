package seedu.duke.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Stock implements Serializable {
    private String symbol;
    private int totalQuantity;
    private ArrayList<Transaction> transactions;

    public Stock(String symbol, int totalQuantity) {
        this.symbol = symbol;
        this.totalQuantity = totalQuantity;
    }

    public void addTransaction() {

    }

}
