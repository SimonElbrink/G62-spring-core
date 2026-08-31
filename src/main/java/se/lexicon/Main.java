package se.lexicon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ModernAppConfig;
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

        ApplicationContext context = new AnnotationConfigApplicationContext(ModernAppConfig.class);

        WalletService walletService = context.getBean(WalletService.class);


        Wallet createdWallet = walletService.create(new Wallet(new BigDecimal("500.00")));

        // Make a deposit
        System.out.println("Before Deposit: " + createdWallet);

        System.out.println(walletService.depositTransaction(
                createdWallet.getWalletId(),
                new BigDecimal("1000.00")
        ));

        Wallet foundWallet = walletService.findWalletInfoById(createdWallet.getWalletId());

        IO.println("Found Wallet: " + foundWallet);


    }
}
