package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.Client;
import by.bsuir.bankSystem.exception.BadRequestException;
import by.bsuir.bankSystem.repo.ClientRepo;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Component
public class ClientDaoImpl implements ClientDao {
    private final ClientRepo clientRepo;

    public ClientDaoImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Override
    public void save(Client client) {
        try {
            clientRepo.save(client);
        } catch (ConstraintViolationException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public Optional<Client> findBySurnameAndNameAndLastname(String surname, String name, String lastName) {
        return clientRepo.findBySurnameAndNameAndLastName(surname, name, lastName);
    }

    @Override
    public Optional<Client> findByPassport(String partPassport, String numberPassport) {
        return clientRepo.findByPartPassportAndNumberPassport(partPassport, numberPassport);
    }

    @Override
    public Optional<Client> findByIdentifierNumber(String identifierNumber) {
        return clientRepo.findByIdentifierNumberPassport(identifierNumber);
    }
}
