package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.BankCard;
import by.bsuir.bankSystem.exception.NotFoundException;
import by.bsuir.bankSystem.repo.BankAccountRepo;
import by.bsuir.bankSystem.repo.BankCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankCardDao {
    private final BankCardRepo bankCardRepo;

    @Autowired
    public BankCardDao(BankCardRepo bankCardRepo) {
        this.bankCardRepo = bankCardRepo;
    }

    public BankCard finByNumber(String number) {
        return bankCardRepo.findByNumber(number).orElseThrow(NotFoundException::new);
    }
}
