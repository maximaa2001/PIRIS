package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalityRepo extends JpaRepository<Nationality, Integer> {
}
