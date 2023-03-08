package by.bsuir.bankSystem.rest;

import by.bsuir.bankSystem.entity.dto.card.CardDto;
import by.bsuir.bankSystem.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.bankSystem.constant.ApiPath.CARD;

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
}
