package by.bsuir.bankSystem.rest;

import by.bsuir.bankSystem.entity.dto.credit.CreditDto;
import by.bsuir.bankSystem.entity.dto.credit.CreditListDto;
import by.bsuir.bankSystem.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.bankSystem.constant.ApiPath.*;

@RestController
public class CreditRest {
    private final CreditService creditService;

    @Autowired
    public CreditRest(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping(CREDITS)
    public CreditListDto findAll() {
        return creditService.findAll();
    }

    @PostMapping(CREDIT)
    public void createCredit(@RequestBody CreditDto creditDto) {
        creditService.createCredit(creditDto);
    }

}
