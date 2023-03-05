package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.*;

import java.util.List;

public interface RefDao {
    List<City> findAllCities();
    List<Disability> findAllDisabilities();
    List<FamilyStatus> findAllFamilyStatuses();
    List<Nationality> findAllNationalities();
    List<DepositType> findAllDepositTypes();
    List<CreditType> findAllCreditTypes();
    List<Currency> findAllCurrencies();
    City findCityById(Integer id);
    Disability findDisabilityById(Integer id);
    FamilyStatus findFamilyStatusById(Integer id);
    Nationality findNationalityById(Integer id);
    DepositType findDepositTypeById(Integer id);
    CreditType findCreditTypeById(Integer id);
    Currency findCurrencyById(String id);

}
