package by.bsuir.bankSystem.dao;

import by.bsuir.bankSystem.entity.domain.Deposit;
import by.bsuir.bankSystem.exception.BadRequestException;
import by.bsuir.bankSystem.repo.DepositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
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
        try {
            depositRepo.save(deposit);
        } catch (ConstraintViolationException e) {
            throw new BadRequestException(e.getMessage());
        }
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
