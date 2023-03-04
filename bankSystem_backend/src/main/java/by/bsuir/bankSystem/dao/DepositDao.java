package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.Deposit;

import java.util.List;

public interface DepositDao {
    void saveDeposit(Deposit deposit);
    void saveAllDeposits(List<Deposit> deposits);
    List<Deposit> findAll();
}
