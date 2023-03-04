package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.MagicDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicDateRepo extends JpaRepository<MagicDate, Integer> {
}
