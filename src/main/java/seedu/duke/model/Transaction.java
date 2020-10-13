package seedu.duke.model;

import java.time.LocalDateTime;

public class Transaction {
    private TransactionType transactionType;
    private int quantity;
    private double unitPrice;
    LocalDateTime dateTimeOfTransaction;

    public Transaction(TransactionType transactionType, int quantity, double unitPrice, LocalDateTime dateTimeOfTransaction) {
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.dateTimeOfTransaction = dateTimeOfTransaction;
    }

    public int getQuantity() {
        return quantity;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return transactionType + " " + quantity + " at " + unitPrice + " on " + dateTimeOfTransaction;
    }
}
