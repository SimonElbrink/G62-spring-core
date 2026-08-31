package se.lexicon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WalletLimitConfig {

    @Value("${wallet.minimum.balance}")
    private BigDecimal minimumBalance;

    @Value("${wallet.maximum.deposit}")
    private BigDecimal maximumDeposit;

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public BigDecimal getMaximumDeposit() {
        return maximumDeposit;
    }
}