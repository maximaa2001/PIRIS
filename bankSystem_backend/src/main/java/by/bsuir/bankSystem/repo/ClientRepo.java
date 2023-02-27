package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
    Optional<Client> findBySurnameAndNameAndLastName(String surname, String name, String lastName);
    Optional<Client> findByPartPassportAndNumberPassport(String partPassport, String numberPassport);
    Optional<Client> findByIdentifierNumberPassport(String identifierNumber);
}
