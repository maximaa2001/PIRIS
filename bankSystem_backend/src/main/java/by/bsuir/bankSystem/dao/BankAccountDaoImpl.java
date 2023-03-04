package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.BankAccount;
import by.bsuir.bankSystem.repo.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankAccountDaoImpl implements BankAccountDao {
    private final BankAccountRepo bankAccountRepo;

    @Autowired
    public BankAccountDaoImpl(BankAccountRepo bankAccountRepo) {
        this.bankAccountRepo = bankAccountRepo;
    }

    @Override
    public void saveAllAccounts(List<BankAccount> bankAccounts) {
        bankAccountRepo.saveAll(bankAccounts);
    }

    @Override
    public BankAccount findBankCashAccount() {
        return bankAccountRepo.findById(1).get();
    }

    @Override
    public BankAccount findBankFond() {
        return bankAccountRepo.findById(2).get();
    }
}
