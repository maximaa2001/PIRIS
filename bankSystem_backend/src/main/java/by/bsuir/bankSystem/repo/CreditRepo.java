package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepo extends JpaRepository<Credit, Integer> {
}
