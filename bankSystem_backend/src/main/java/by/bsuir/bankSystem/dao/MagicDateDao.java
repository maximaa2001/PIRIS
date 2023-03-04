package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.MagicDate;
import by.bsuir.bankSystem.repo.MagicDateRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MagicDateDao {
    private final MagicDateRepo magicDateRepo;

    public MagicDateDao(MagicDateRepo magicDateRepo) {
        this.magicDateRepo = magicDateRepo;
    }

    public List<MagicDate> findAll() {
        return magicDateRepo.findAll();
    }
    public MagicDate save(LocalDate date) {
        MagicDate magicDate = new MagicDate();
        magicDate.setDate(date);
        return magicDateRepo.save(magicDate);
    }
}
