package se.lexicon.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents a transaction in the wallet, such as a deposit or withdrawal.
 */
public class Transaction {

    private String transactionId;
    private final String walletId;
    private final TransactionType type;
    private final BigDecimal amount;
    private final LocalDateTime dateTime;

    /**
     * Constructor to create a transaction with type and amount.
     * Automatically generates a unique ID and sets the timestamp to the current time.
     */
    public Transaction(String walletId, TransactionType type, BigDecimal amount) {
        this.walletId = walletId;
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getWalletId() {
        return walletId;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "[" + dateTime + "] TransactionID: " + transactionId + ", " + type + ": SEK " + amount;
    }
}
