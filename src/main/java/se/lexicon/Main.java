package se.lexicon;

import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.dao.impl.InMemoryTransactionDao;
import se.lexicon.dao.impl.InMemoryWalletDao;
import se.lexicon.model.Wallet;
import se.lexicon.service.WalletService;
import se.lexicon.service.impl.WalletServiceImpl;

import java.math.BigDecimal;

class Main {
    void main() {

        WalletDao walletDao = new InMemoryWalletDao();
        TransactionDao transactionDao = new InMemoryTransactionDao();
        WalletService walletService = new WalletServiceImpl(walletDao, transactionDao);

        Wallet createdWallet = walletService.create(new Wallet(new BigDecimal("500.00")));

        // Make a deposit
        System.out.println("Before Deposit: " + createdWallet);

        System.out.println(walletService.depositTransaction(
                createdWallet.getWalletId(),
                new BigDecimal("1000.00")
        ));


    }
}
