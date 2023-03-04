package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.BankAccount;

import java.util.List;

public interface BankAccountDao {
    void saveAllAccounts(List<BankAccount> bankAccounts);
    BankAccount findBankCashAccount();
    BankAccount findBankFond();
}
