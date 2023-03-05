package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepo extends JpaRepository<CreditType, Integer> {
}
