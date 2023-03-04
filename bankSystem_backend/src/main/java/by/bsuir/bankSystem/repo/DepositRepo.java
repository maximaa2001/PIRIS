package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepo extends JpaRepository<Deposit, Integer> {
}
