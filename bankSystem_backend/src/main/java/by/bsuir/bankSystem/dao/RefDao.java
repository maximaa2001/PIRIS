package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.City;
import by.bsuir.bankSystem.entity.domain.Disability;
import by.bsuir.bankSystem.entity.domain.FamilyStatus;
import by.bsuir.bankSystem.entity.domain.Nationality;

import java.util.List;

public interface RefDao {
    List<City> findAllCities();
    List<Disability> findAllDisabilities();
    List<FamilyStatus> findAllFamilyStatuses();
    List<Nationality> findAllNationalities();
    City findCityById(Integer id);
    Disability findDisabilityById(Integer id);
    FamilyStatus findFamilyStatusById(Integer id);
    Nationality findNationalityById(Integer id);

}
