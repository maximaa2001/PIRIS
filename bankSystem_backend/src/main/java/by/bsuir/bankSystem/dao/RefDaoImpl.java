package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.City;
import by.bsuir.bankSystem.entity.domain.Disability;
import by.bsuir.bankSystem.entity.domain.FamilyStatus;
import by.bsuir.bankSystem.entity.domain.Nationality;
import by.bsuir.bankSystem.exception.NotFoundException;
import by.bsuir.bankSystem.repo.CityRepo;
import by.bsuir.bankSystem.repo.DisabilityRepo;
import by.bsuir.bankSystem.repo.FamilyStatusRepo;
import by.bsuir.bankSystem.repo.NationalityRepo;
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

    @Autowired
    public RefDaoImpl(CityRepo cityRepo, DisabilityRepo disabilityRepo,
                      FamilyStatusRepo familyStatusRepo, NationalityRepo nationalityRepo) {
        this.cityRepo = cityRepo;
        this.disabilityRepo = disabilityRepo;
        this.familyStatusRepo = familyStatusRepo;
        this.nationalityRepo = nationalityRepo;
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
}
