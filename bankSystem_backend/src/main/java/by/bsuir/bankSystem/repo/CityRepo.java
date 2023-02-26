package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Integer> {
}
