package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {
}
