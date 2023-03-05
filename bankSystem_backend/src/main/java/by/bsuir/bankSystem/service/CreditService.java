package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.BankAccountDao;
import by.bsuir.bankSystem.dao.ClientDao;
import by.bsuir.bankSystem.dao.CreditDao;
import by.bsuir.bankSystem.dao.RefDao;
import by.bsuir.bankSystem.entity.domain.*;
import by.bsuir.bankSystem.entity.dto.credit.CreditDto;
import by.bsuir.bankSystem.entity.dto.credit.CreditListDto;
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
public class CreditService {
    private final CreditDao creditDao;
    private final ClientDao clientDao;
    private final RefDao refDao;
    private final Validator validator;
    private final BankAccountDao bankAccountDao;

    @Autowired
    public CreditService(CreditDao creditDao, RefDao refDao, ClientDao clientDao, Validator validator,
                         BankAccountDao bankAccountDao) {
        this.creditDao = creditDao;
        this.refDao = refDao;
        this.clientDao = clientDao;
        this.validator = validator;
        this.bankAccountDao = bankAccountDao;
    }

    public CreditListDto findAll() {
        return CreditListDto.of(creditDao.findAll());
    }

    @Transactional
    public void createCredit(CreditDto creditDto) {
        Credit deposit = defaultCredit(creditDto);
        BankAccount bankCashAccount = bankAccountDao.findBankCashAccount();
        BankAccount bankFondAccount = bankAccountDao.findBankFond();

        bankFondAccount.setDebit(bankCashAccount.getDebit().subtract(deposit.getSum()));

        BankAccount currentAccount = createRealAccount(deposit.getSum());
        BankAccount percentAccount = createPercentAccount();

        bankCashAccount.setDebit(bankCashAccount.getDebit().add(deposit.getSum()));
        bankCashAccount.setCredit(bankCashAccount.getCredit().subtract(deposit.getSum()));

        bankAccountDao.saveAllAccounts(List.of(percentAccount, currentAccount, bankCashAccount, bankFondAccount));
        deposit.setPercentAccount(percentAccount);
        deposit.setCurrentAccount(currentAccount);
        creditDao.saveCredit(deposit);
    }

    private Credit defaultCredit(CreditDto creditDto) {
        CreditType creditType = refDao.findCreditTypeById(creditDto.getCreditType());
        Currency currency = refDao.findCurrencyById(creditDto.getCurrency());
        Client client = clientDao.findById(creditDto.getClient()).orElseThrow(NotFoundException::new);
        return Credit.builder()
                .creditType(creditType)
                .contractNumber(creditDto.getContractNumber())
                .currency(currency)
                .startDate(validator.validateDate(creditDto.getStartDate().trim()))
                .endDate(validator.validateDate(creditDto.getEndDate().trim()))
                .sum((creditDto.getSum() != null && !creditDto.getSum().trim().isEmpty()) ? new BigDecimal(creditDto.getSum()) : null)
                .percent(Double.valueOf(creditDto.getPercent()))
                .client(client)
                .isOpen(true)
                .build();
    }

    private BankAccount createRealAccount(BigDecimal sum) {
        return BankAccount.builder()
                .number("3014".concat(createRandomNumber()))
                .code("3014")
                .activity("PASSIVE")
                .credit(BigDecimal.ZERO.subtract(sum))
                .debit(sum)
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
