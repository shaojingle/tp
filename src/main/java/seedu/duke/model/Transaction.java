package seedu.duke.model;

public class Transaction {
    private TransactionType transactionType;
    private int quantity;
    private double unitPrice;

    public Transaction(TransactionType transactionType, int quantity, double unitPrice) {
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

}
