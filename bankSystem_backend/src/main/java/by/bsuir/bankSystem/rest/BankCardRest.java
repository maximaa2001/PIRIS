package by.bsuir.bankSystem.rest;

import by.bsuir.bankSystem.entity.dto.card.CardDto;
import by.bsuir.bankSystem.entity.dto.card.CreditMoney;
import by.bsuir.bankSystem.entity.dto.card.MoneyDto;
import by.bsuir.bankSystem.entity.dto.card.NumberDto;
import by.bsuir.bankSystem.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.bankSystem.constant.ApiPath.*;

@RestController
public class BankCardRest {
    private final BankCardService bankCardService;

    @Autowired
    public BankCardRest(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }

    @PostMapping(CARD)
    public void checkCard(@RequestBody CardDto cardDto) {
        bankCardService.checkCard(cardDto);
    }

    @PostMapping(CHANGE_CREDIT_MONEY)
    public void changeCreditMoney(@RequestBody CreditMoney creditMoney) {
        bankCardService.changeCreditMoney(creditMoney);
    }
    @PostMapping(GET_CREDIT_MONEY)
    public MoneyDto getCreditMoney(@RequestBody NumberDto numberDto) {
        return bankCardService.getCreditMoney(numberDto);
    }

}
