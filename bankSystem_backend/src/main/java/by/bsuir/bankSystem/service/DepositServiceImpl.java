package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.BankAccountDao;
import by.bsuir.bankSystem.dao.ClientDao;
import by.bsuir.bankSystem.dao.DepositDao;
import by.bsuir.bankSystem.dao.RefDao;
import by.bsuir.bankSystem.entity.domain.*;
import by.bsuir.bankSystem.entity.dto.deposit.DepositDto;
import by.bsuir.bankSystem.exception.NotFoundException;
import by.bsuir.bankSystem.util.Validator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Log4j2
public class DepositServiceImpl implements DepositService {
    private final DepositDao depositDao;
    private final BankAccountDao bankAccountDao;
    private final RefDao refDao;
    private final ClientDao clientDao;
    private final Validator validator;

    @Autowired
    public DepositServiceImpl(DepositDao depositDao, BankAccountDao bankAccountDao, RefDao refDao,
                              Validator validator, ClientDao clientDao) {
        this.depositDao = depositDao;
        this.bankAccountDao = bankAccountDao;
        this.refDao = refDao;
        this.clientDao = clientDao;
        this.validator = validator;
    }

    @Override
    @Transactional
    public void createDeposit(DepositDto depositDto) {
        Deposit deposit = defaultDeposit(depositDto);
        BankAccount bankCashAccount = bankAccountDao.findBankCashAccount();
        BankAccount bankFondAccount = bankAccountDao.findBankFond();

        bankCashAccount.setDebit(bankCashAccount.getDebit().add(deposit.getSum()));
        bankCashAccount.setCredit(bankCashAccount.getCredit().subtract(deposit.getSum()));

        BankAccount currentAccount = createRealAccount(deposit.getSum());
        BankAccount percentAccount = createPercentAccount();

        bankFondAccount.setCredit(bankFondAccount.getCredit().add(deposit.getSum()));

        bankAccountDao.saveAllAccounts(List.of(percentAccount, currentAccount, bankCashAccount, bankFondAccount));
        deposit.setPercentAccount(percentAccount);
        deposit.setCurrentAccount(currentAccount);
        depositDao.saveDeposit(deposit);
    }

    private Deposit defaultDeposit(DepositDto depositDto) {
        DepositType depositType = refDao.findDepositTypeById(depositDto.getDepositTypeId());
        Currency currency = refDao.findCurrencyById(depositDto.getIso());
        Client client = clientDao.findById(depositDto.getClientId()).orElseThrow(NotFoundException::new);
        return Deposit.builder()
                .depositType(depositType)
                .contractNumber(depositDto.getContractNumber())
                .currency(currency)
                .contractTerm(depositDto.getContractTerm())
                .startDate(validator.validateDate(depositDto.getStartDate().trim()))
                .endDate(validator.validateDate(depositDto.getEndDate().trim()))
                .sum((depositDto.getSum() != null && !depositDto.getSum().trim().isEmpty()) ? new BigDecimal(depositDto.getSum()) : null)
                .client(client)
                .build();
    }

    private BankAccount createRealAccount(BigDecimal sum) {
        return BankAccount.builder()
                .number("3014".concat(createRandomNumber()))
                .code("3014")
                .activity("PASSIVE")
                .credit(sum)
                .debit(BigDecimal.ZERO.subtract(sum))
                .build();
    }

    private BankAccount createPercentAccount() {
        return BankAccount.builder()
                .number("3014".concat(createRandomNumber()))
                .code("3014")
                .activity("PASSIVE")
                .credit(BigDecimal.ZERO)
                .debit(BigDecimal.ZERO)
                .build();
    }

    private String createRandomNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append((int) Math.ceil(Math.random() * 10));
        }
        return sb.toString();
    }
}
