package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.MagicDateDao;
import by.bsuir.bankSystem.entity.domain.MagicDate;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MagicDateService {
    private final MagicDateDao magicDateDao;

    @Autowired
    public MagicDateService(MagicDateDao magicDateDao) {
        this.magicDateDao = magicDateDao;
    }

    public MagicDate getDate() {
        List<MagicDate> magicDates = magicDateDao.findAll();
        if (magicDates.isEmpty()) {
            return magicDateDao.save(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1));
        } else {
            return magicDates.stream().sorted(Comparator.comparing(MagicDate::getDate)).collect(Collectors.toList()).get(0);
        }
    }
}
