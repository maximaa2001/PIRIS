package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.ClientDao;
import by.bsuir.bankSystem.dao.RefDao;
import by.bsuir.bankSystem.entity.domain.*;
import by.bsuir.bankSystem.entity.dto.RefDto;
import by.bsuir.bankSystem.entity.dto.city.CityDto;
import by.bsuir.bankSystem.entity.dto.client.ClientDto;
import by.bsuir.bankSystem.entity.dto.creditType.CreditTypeDto;
import by.bsuir.bankSystem.entity.dto.currency.CurrencyDto;
import by.bsuir.bankSystem.entity.dto.depositType.DepositTypeDto;
import by.bsuir.bankSystem.entity.dto.disability.DisabilityDto;
import by.bsuir.bankSystem.entity.dto.familyStatus.FamilyStatusDto;
import by.bsuir.bankSystem.entity.dto.nationality.NationalityDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class RefServiceImpl implements RefService {
    private final RefDao refDao;
    private final ClientDao clientDao;

    @Autowired
    public RefServiceImpl(RefDao refDao, ClientDao clientDao) {
        this.refDao = refDao;
        this.clientDao = clientDao;
    }

    @Override
    @Transactional
    public RefDto getAllClientReferences() {
        List<City> allCities = refDao.findAllCities();
        List<Disability> allDisabilities = refDao.findAllDisabilities();
        List<FamilyStatus> allFamilyStatuses = refDao.findAllFamilyStatuses();
        List<Nationality> allNationalities = refDao.findAllNationalities();
        return new RefDto(allCities.stream().map(CityDto::of).collect(Collectors.toList()),
                allDisabilities.stream().map(DisabilityDto::of).collect(Collectors.toList()),
                allFamilyStatuses.stream().map(FamilyStatusDto::of).collect(Collectors.toList()),
                allNationalities.stream().map(NationalityDto::of).collect(Collectors.toList()));
    }

    @Override
    public RefDto getAllDepositReferences() {
        List<DepositType> allDepositTypes = refDao.findAllDepositTypes();
        List<Currency> allCurrencies = refDao.findAllCurrencies();
        List<Client> allClients = clientDao.findClients();
        return new RefDto(new ArrayList<>(allDepositTypes.stream().map(DepositTypeDto::of).collect(Collectors.toList())),
                allCurrencies.stream().map(CurrencyDto::of).collect(Collectors.toList()),
                allClients.stream().map(ClientDto::of).collect(Collectors.toList()));
    }

    @Override
    public RefDto getAllCreditReferences() {
        List<CreditType> allCreditTypes = refDao.findAllCreditTypes();
        List<Currency> allCurrencies = refDao.findAllCurrencies();
        List<Client> allClients = clientDao.findClients();
        return new RefDto(allCreditTypes.stream().map(CreditTypeDto::of).collect(Collectors.toList()),
                allCurrencies.stream().map(CurrencyDto::of).collect(Collectors.toList()),
                allClients.stream().map(ClientDto::of).collect(Collectors.toList()));
    }
}
