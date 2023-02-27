package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.ClientDao;
import by.bsuir.bankSystem.dao.RefDao;
import by.bsuir.bankSystem.entity.domain.*;
import by.bsuir.bankSystem.entity.dto.client.ClientDto;
import by.bsuir.bankSystem.util.Validator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Log4j2
public class ClientServiceImpl implements ClientService {
    private final ClientDao clientDao;
    private final RefDao refDao;
    private final Validator validator;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao, RefDao refDao, Validator validator) {
        this.clientDao = clientDao;
        this.refDao = refDao;
        this.validator = validator;
    }

    @Override
    public void createClient(ClientDto clientDto) {
        clientDao.save(defaultClient(clientDto));
    }

    private Client defaultClient(ClientDto clientDto) {
        City cityLive = refDao.findCityById(clientDto.getCityLiveId());
        City cityRegistration = refDao.findCityById(clientDto.getCityRegistrationId());
        FamilyStatus familyStatus = refDao.findFamilyStatusById(clientDto.getFamilyStatusId());
        Nationality nationality = refDao.findNationalityById(clientDto.getNationalityId());
        Disability disability = refDao.findDisabilityById(clientDto.getDisabilityId());
        validate(clientDto);
        return Client.builder()
                .surname(clientDto.getSurname().trim())
                .name(clientDto.getName().trim())
                .lastName(clientDto.getLastName().trim())
                .dateBirth(validator.validateDate(clientDto.getDateBirth().trim()))
                .partPassport(clientDto.getPartPassport().trim())
                .numberPassport(clientDto.getNumberPassport().trim())
                .sourcePassport(clientDto.getSourcePassport().trim())
                .startDatePassport(validator.validateDate(clientDto.getStartDatePassport().trim()))
                .identifierNumberPassport(clientDto.getIdentifierNumberPassport().trim())
                .placeBirth(clientDto.getPlaceBirth().trim())
                .cityLive(cityLive)
                .address(clientDto.getAddress().trim())
                .homePhone(clientDto.getHomePhone().trim().replaceAll("-", ""))
                .mobilePhone(clientDto.getMobilePhone().trim().replaceAll("-", ""))
                .email(clientDto.getEmail().trim())
                .work(clientDto.getWork().trim())
                .position(clientDto.getPosition().trim())
                .cityRegistration(cityRegistration)
                .familyStatus(familyStatus)
                .nationality(nationality)
                .disability(disability)
                .isPensioner(clientDto.getIsPensioner())
                .salaryMonth(new BigDecimal(clientDto.getSalaryMonth().trim()))
                .build();

    }

    private void validate(ClientDto clientDto) {
        validator.checkExistUserWith(clientDto.getSurname(), clientDto.getName(), clientDto.getLastName());
        validator.checkExistUserWith(clientDto.getPartPassport(), clientDto.getNumberPassport());
        validator.checkExistUserWith(clientDto.getIdentifierNumberPassport());
    }
}
