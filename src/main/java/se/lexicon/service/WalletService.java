package se.lexicon.service;

import se.lexicon.model.Wallet;

import java.math.BigDecimal;

public interface WalletService {

    Wallet create(Wallet wallet);

    Wallet depositTransaction(String walletId, BigDecimal amount);

    Wallet withdrawTransaction(String walletId, BigDecimal amount);

    Wallet findWalletInfoById(String walletId);
}
