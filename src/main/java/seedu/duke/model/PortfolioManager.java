package seedu.duke.model;


import java.util.ArrayList;

public class PortfolioManager {
    private Portfolio portfolio;

    public PortfolioManager() {
        // load portfolio object from file
        // if does not exists, create the file
        portfolio = new Portfolio();
    }

    public void buyStock(String symbol, int quantity, double buyPrice) {
        portfolio.buyStock(symbol, quantity, buyPrice);
    }

    public ArrayList<Stock> getAllStocks() {
        return portfolio.getAllStocks();
    }

}
