package se.lexicon.service.impl;

import se.lexicon.config.WalletLimitConfig;
import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.model.Transaction;
import se.lexicon.model.TransactionType;
import se.lexicon.model.Wallet;
import se.lexicon.service.WalletService;

import java.math.BigDecimal;


public class WalletServiceImpl implements WalletService {

    private WalletDao walletDao;
    private TransactionDao transactionDao;

    private WalletLimitConfig walletLimitConfig;


    public WalletServiceImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    public WalletServiceImpl(WalletDao walletDao, TransactionDao transactionDao, WalletLimitConfig walletLimitConfig) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
        this.walletLimitConfig = walletLimitConfig;
    }


    @Override
    public Wallet create(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet object cannot be null.");
        }
        return walletDao.save(wallet);
    }

    @Override
    public Wallet depositTransaction(String walletId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }

        Wallet wallet = walletDao.findById(walletId)
                .orElseThrow(() -> new IllegalArgumentException(walletId));

        BigDecimal maximumDeposit = walletLimitConfig.getMaximumDeposit();

        if (amount.compareTo(maximumDeposit) > 0) {
            throw new IllegalArgumentException(
                    "Deposit amount exceeds maximum limit of " + maximumDeposit);
        }

        wallet.deposit(amount);
        walletDao.update(wallet);
        transactionDao.save(new Transaction(walletId, TransactionType.DEPOSIT, amount));
        return wallet;
    }

    @Override
    public Wallet withdrawTransaction(String walletId, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        Wallet wallet = walletDao.findById(walletId)
                .orElseThrow(() -> new IllegalArgumentException(walletId));

        if (wallet.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        wallet.withdraw(amount);
        walletDao.update(wallet);
        transactionDao.save(new Transaction(walletId, TransactionType.WITHDRAW, amount));

        return wallet;
    }

    @Override
    public Wallet findWalletInfoById(String walletId) {
        return walletDao.findById(walletId)
                .orElseThrow(() -> new IllegalArgumentException(walletId));
    }
}
