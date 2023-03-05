package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.Credit;
import by.bsuir.bankSystem.exception.BadRequestException;
import by.bsuir.bankSystem.repo.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Component
public class CreditDao {
    private final CreditRepo creditRepo;

    @Autowired
    public CreditDao(CreditRepo creditRepo) {
        this.creditRepo = creditRepo;
    }

    public void saveCredit(Credit credit) {
        try {
            creditRepo.save(credit);
        } catch (ConstraintViolationException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    public void saveAllCredits(List<Credit> credits) {
        creditRepo.saveAll(credits);
    }

    public List<Credit> findAll() {
        return creditRepo.findAll();
    }
}
