package se.lexicon.model;

import java.math.BigDecimal;

/**
 * Represents a user's wallet that can store balance and transaction history.
 */
public class Wallet {

    private String walletId;

    private BigDecimal balance;

    /**
     * Constructor to create a wallet with an owner and initial balance.
     * Generates a unique ID automatically.
     */
    public Wallet(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        this.balance = this.balance.subtract(amount);
    }

    public String getWalletId() {
        return walletId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public String toString() {
        return "Wallet ID: " + walletId + " ,Balance: " + balance;
    }
}
