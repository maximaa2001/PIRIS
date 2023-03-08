package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.dao.BankCardDao;
import by.bsuir.bankSystem.entity.domain.BankCard;
import by.bsuir.bankSystem.entity.dto.card.CardDto;
import by.bsuir.bankSystem.exception.BadRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class BankCardService {
    private final BankCardDao bankCardDao;

    @Autowired
    public BankCardService(BankCardDao bankCardDao) {
        this.bankCardDao = bankCardDao;
    }

    public void checkCard(CardDto cardDto) {
        BankCard bankCard = bankCardDao.finByNumber(cardDto.getNumber());
        if (!bankCard.getPin().equals(cardDto.getPin())) {
            throw new BadRequestException("pin");
        }
    }
}
