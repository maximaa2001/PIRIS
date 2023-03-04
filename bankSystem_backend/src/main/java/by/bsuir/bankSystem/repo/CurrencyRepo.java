package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, String> {
}
