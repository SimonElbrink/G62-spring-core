package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.dao.impl.InMemoryTransactionDao;
import se.lexicon.dao.impl.InMemoryWalletDao;
import se.lexicon.service.WalletService;
import se.lexicon.service.impl.WalletServiceImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class ModernAppConfig {

    @Bean
    public WalletDao walletDao(){
        return new InMemoryWalletDao();
    }

    @Bean
    public TransactionDao transactionDao() {
        // Returns an in-memory implementation of TransactionDao interface
        return new InMemoryTransactionDao();
    }

    @Bean
    public WalletService walletService (){
        WalletService walletService = new WalletServiceImpl(walletDao(), transactionDao(), walletLimitConfig());

        return walletService;
    }

    @Bean
    public WalletLimitConfig walletLimitConfig() {

        return new WalletLimitConfig();
    }










}
