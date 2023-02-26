package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.RefDao;
import by.bsuir.bankSystem.entity.domain.City;
import by.bsuir.bankSystem.entity.domain.Disability;
import by.bsuir.bankSystem.entity.domain.FamilyStatus;
import by.bsuir.bankSystem.entity.domain.Nationality;
import by.bsuir.bankSystem.entity.dto.RefDto;
import by.bsuir.bankSystem.entity.dto.city.CityDto;
import by.bsuir.bankSystem.entity.dto.disability.DisabilityDto;
import by.bsuir.bankSystem.entity.dto.familyStatus.FamilyStatusDto;
import by.bsuir.bankSystem.entity.dto.nationality.NationalityDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class RefServiceImpl implements RefService {
    private final RefDao refDao;

    @Autowired
    public RefServiceImpl(RefDao refDao) {
        this.refDao = refDao;
    }

    @Override
    @Transactional
    public RefDto getAllReferences() {
        List<City> allCities = refDao.findAllCities();
        List<Disability> allDisabilities = refDao.findAllDisabilities();
        List<FamilyStatus> allFamilyStatuses = refDao.findAllFamilyStatuses();
        List<Nationality> allNationalities = refDao.findAllNationalities();
        return new RefDto(allCities.stream().map(CityDto::of).collect(Collectors.toList()),
                allDisabilities.stream().map(DisabilityDto::of).collect(Collectors.toList()),
                allFamilyStatuses.stream().map(FamilyStatusDto::of).collect(Collectors.toList()),
                allNationalities.stream().map(NationalityDto::of).collect(Collectors.toList()));
    }
}
