package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.*;
import by.bsuir.bankSystem.entity.domain.*;
import by.bsuir.bankSystem.entity.dto.deposit.DepositDto;
import by.bsuir.bankSystem.exception.NotFoundException;
import by.bsuir.bankSystem.util.Validator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class DepositServiceImpl implements DepositService {
    private static final BigDecimal PERCENT_SCALE_VALUE = BigDecimal.valueOf(10 * 100);
    private final DepositDao depositDao;
    private final BankAccountDao bankAccountDao;
    private final RefDao refDao;
    private final ClientDao clientDao;
    private final Validator validator;
    private final MagicDateService magicDateService;
    private final MagicDateDao magicDateDao;

    @Autowired
    public DepositServiceImpl(DepositDao depositDao, BankAccountDao bankAccountDao, RefDao refDao,
                              Validator validator, ClientDao clientDao, MagicDateService magicDateService,
                              MagicDateDao magicDateDao) {
        this.depositDao = depositDao;
        this.bankAccountDao = bankAccountDao;
        this.refDao = refDao;
        this.clientDao = clientDao;
        this.validator = validator;
        this.magicDateService = magicDateService;
        this.magicDateDao = magicDateDao;
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

    @Override
    @Transactional
    public void closeDay(int monthAmount) {
        MagicDate date = magicDateService.getDate();
        LocalDate previousDate = date.getDate();
        LocalDate currentDate = date.getDate().plusMonths(monthAmount);
        BankAccount bankFondAccount = bankAccountDao.findBankFond();
        BankAccount bankCashAccount = bankAccountDao.findBankCashAccount();
        magicDateDao.save(currentDate);
        List<Deposit> deposits = depositDao.findAll().stream().filter(Deposit::getIsOpen).sorted(Comparator.comparing(Deposit::getStartDate))
                .map(deposit -> calculatePercents(deposit, previousDate, currentDate, bankFondAccount, bankCashAccount))
                .collect(Collectors.toList());
        List<BankAccount> accounts = deposits
                .stream()
                .map(deposit -> List.of(deposit.getCurrentAccount(), deposit.getPercentAccount()))
                .flatMap(java.util.Collection::stream).collect(Collectors.toList());
        accounts.addAll(List.of(bankCashAccount, bankFondAccount));
        bankAccountDao.saveAllAccounts(accounts);
        depositDao.saveAllDeposits(deposits);
    }

    private Deposit calculatePercents(Deposit deposit, LocalDate previousDate, LocalDate currentDate,
                                      BankAccount bankFundAccount, BankAccount bankCashAccount) {
        BigDecimal monthPercents = BigDecimal.valueOf(deposit.getPercent()).divide(PERCENT_SCALE_VALUE, RoundingMode.DOWN)
                .multiply(deposit.getSum())
                .divide(BigDecimal.valueOf(12), RoundingMode.HALF_EVEN);

        LocalDate startDate = previousDate.isAfter(deposit.getStartDate())
                ? previousDate
                : deposit.getStartDate();
        LocalDate endDate = currentDate.isAfter(deposit.getEndDate())
                ? deposit.getEndDate()
                : currentDate;
        Period period = Period.between(startDate, endDate);
        int months = (int) period.toTotalMonths();

        BigDecimal percentMoney = monthPercents.multiply(BigDecimal.valueOf(months));

        bankFundAccount.setDebit(bankFundAccount.getDebit().subtract(percentMoney));

        BankAccount percentAccount = deposit.getPercentAccount();
        percentAccount.setCredit(percentAccount.getCredit().add(percentMoney));
        percentAccount.setDebit(percentAccount.getDebit().subtract(percentMoney));

        bankCashAccount.setDebit(bankCashAccount.getDebit().add(percentMoney));
        bankCashAccount.setCredit(bankCashAccount.getCredit().subtract(percentMoney));

        if (deposit.getEndDate().isBefore(currentDate) || deposit.getEndDate().isEqual(currentDate)) {
            closeDeposit(deposit, bankCashAccount, bankFundAccount);
        }
        return deposit;
    }

    private void closeDeposit(Deposit deposit, BankAccount bankCashAccount, BankAccount bankFundAccount) {
        BigDecimal depositSum = deposit.getSum();
        bankFundAccount.setDebit(bankFundAccount.getDebit().subtract(depositSum));

        BankAccount currentAccount = deposit.getCurrentAccount();
        currentAccount.setCredit(currentAccount.getCredit().add(depositSum));
        currentAccount.setDebit(currentAccount.getDebit().subtract(depositSum));

        bankCashAccount.setDebit(bankCashAccount.getDebit().add(depositSum));
        bankCashAccount.setCredit(bankCashAccount.getCredit().subtract(depositSum));

        deposit.setIsOpen(false);
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
                .isOpen(true)
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
