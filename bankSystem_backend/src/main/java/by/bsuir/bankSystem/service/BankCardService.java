package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.BankAccountDao;
import by.bsuir.bankSystem.dao.BankCardDao;
import by.bsuir.bankSystem.entity.domain.BankAccount;
import by.bsuir.bankSystem.entity.domain.BankCard;
import by.bsuir.bankSystem.entity.dto.card.CardDto;
import by.bsuir.bankSystem.entity.dto.card.CreditMoney;
import by.bsuir.bankSystem.entity.dto.card.MoneyDto;
import by.bsuir.bankSystem.entity.dto.card.NumberDto;
import by.bsuir.bankSystem.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class BankCardService {
    private final BankCardDao bankCardDao;
    private final BankAccountDao bankAccountDao;

    @Autowired
    public BankCardService(BankCardDao bankCardDao, BankAccountDao bankAccountDao) {
        this.bankCardDao = bankCardDao;
        this.bankAccountDao = bankAccountDao;
    }

    public void checkCard(CardDto cardDto) {
        BankCard bankCard = bankCardDao.finByNumber(cardDto.getNumber());
        if (!bankCard.getPin().equals(cardDto.getPin())) {
            throw new BadRequestException("pin error");
        }
    }

    @Transactional
    public void changeCreditMoney(CreditMoney creditMoney) {
        BankCard bankCard = bankCardDao.finByNumber(creditMoney.getNumber());
        BankAccount currentAccount = bankCard.getCredit().getCurrentAccount();
        if(creditMoney.getMoney().longValue() <= 0 || currentAccount.getDebit().longValue() < creditMoney.getMoney().longValue()) {
            throw new BadRequestException("no count");
        }
        currentAccount.setDebit(currentAccount.getDebit().subtract(creditMoney.getMoney()));
        bankAccountDao.saveAllAccounts(List.of(currentAccount));
    }

    @Transactional
    public MoneyDto getCreditMoney(NumberDto numberDto) {
        BankCard bankCard = bankCardDao.finByNumber(numberDto.getNumber());
        BankAccount currentAccount = bankCard.getCredit().getCurrentAccount();
        return new MoneyDto(currentAccount.getDebit());
    }
}
