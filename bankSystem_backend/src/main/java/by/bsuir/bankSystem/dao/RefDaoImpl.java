package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.*;
import by.bsuir.bankSystem.exception.NotFoundException;
import by.bsuir.bankSystem.repo.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class RefDaoImpl implements RefDao {
    private final CityRepo cityRepo;
    private final DisabilityRepo disabilityRepo;
    private final FamilyStatusRepo familyStatusRepo;
    private final NationalityRepo nationalityRepo;
    private final DepositTypeRepo depositTypeRepo;
    private final CurrencyRepo currencyRepo;

    @Autowired
    public RefDaoImpl(CityRepo cityRepo, DisabilityRepo disabilityRepo,
                      FamilyStatusRepo familyStatusRepo, NationalityRepo nationalityRepo,
                      DepositTypeRepo depositTypeRepo, CurrencyRepo currencyRepo) {
        this.cityRepo = cityRepo;
        this.disabilityRepo = disabilityRepo;
        this.familyStatusRepo = familyStatusRepo;
        this.nationalityRepo = nationalityRepo;
        this.depositTypeRepo = depositTypeRepo;
        this.currencyRepo = currencyRepo;
    }

    @Override
    public List<City> findAllCities() {
        return cityRepo.findAll();
    }

    @Override
    public List<Disability> findAllDisabilities() {
        return disabilityRepo.findAll();
    }

    @Override
    public List<FamilyStatus> findAllFamilyStatuses() {
        return familyStatusRepo.findAll();
    }

    @Override
    public List<Nationality> findAllNationalities() {
        return nationalityRepo.findAll();
    }

    @Override
    public City findCityById(Integer id) {
        return cityRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Disability findDisabilityById(Integer id) {
        return disabilityRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public FamilyStatus findFamilyStatusById(Integer id) {
        return familyStatusRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Nationality findNationalityById(Integer id) {
        return nationalityRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public DepositType findDepositTypeById(Integer id) {
        return depositTypeRepo.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Currency findCurrencyById(String id) {
        return currencyRepo.findById(id).orElseThrow(NotFoundException::new);
    }
}
