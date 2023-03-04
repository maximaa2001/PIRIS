package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.DepositType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositTypeRepo extends JpaRepository<DepositType, Integer> {
}
