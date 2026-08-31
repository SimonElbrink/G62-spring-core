package se.lexicon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/// @Component is used to mark a class as a Spring-managed bean.
/// It tells the Spring IoC container to automatically detect,
/// create, and manage this class during component scanning.
///
/// Use @Component when:
/// - The class represents a core application component (service, helper, utility, etc.)
/// - You want Spring to handle object creation and dependency injection
/// - No more specific stereotype annotation (@Service, @Repository, @Controller) applies
/// Annotation-based Approach
///@Component
/// - **`@Component`** – Generic stereotype for any Spring-managed component
///- **`@Service`** – Indicates a service layer component (business logic)
///- **`@Repository`** – Marks a DAO/repository class (data access layer)
///- **`@Controller`** – Designates a web controller (presentation layer)

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