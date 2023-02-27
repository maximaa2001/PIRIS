package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.Client;

import java.util.Optional;

public interface ClientDao {
    void save(Client client);
    Optional<Client> findBySurnameAndNameAndLastname(String surname, String name, String lastName);
    Optional<Client> findByPassport(String partPassport, String numberPassport);
    Optional<Client> findByIdentifierNumber(String identifierNumber);
}
