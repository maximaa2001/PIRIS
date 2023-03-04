package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.Deposit;
import by.bsuir.bankSystem.repo.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepositDaoImpl implements DepositDao {
    private final DepositRepo depositRepo;

    @Autowired
    public DepositDaoImpl(DepositRepo depositRepo) {
        this.depositRepo = depositRepo;
    }

    @Override
    public void saveDeposit(Deposit deposit) {
        depositRepo.save(deposit);
    }

    @Override
    public void saveAllDeposits(List<Deposit> deposits) {
        depositRepo.saveAll(deposits);
    }

    @Override
    public List<Deposit> findAll() {
        return depositRepo.findAll();
    }
}
