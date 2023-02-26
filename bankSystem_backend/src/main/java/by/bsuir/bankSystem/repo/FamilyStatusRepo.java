package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.FamilyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyStatusRepo extends JpaRepository<FamilyStatus, Integer> {
}
