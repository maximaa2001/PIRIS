package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.Disability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisabilityRepo extends JpaRepository<Disability, Integer> {
}
