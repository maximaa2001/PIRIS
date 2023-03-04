package by.bsuir.bankSystem.rest;

import by.bsuir.bankSystem.entity.dto.deposit.DepositDto;
import by.bsuir.bankSystem.entity.dto.deposit.DepositListDto;
import by.bsuir.bankSystem.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.bsuir.bankSystem.constant.ApiPath.*;

@RestController
public class DepositRest {
    private final DepositService depositService;

    @Autowired
    public DepositRest(DepositService depositService) {
        this.depositService = depositService;
    }

    @GetMapping(DEPOSITS)
    public DepositListDto findAll() {
        return depositService.findAll();
    }

    @PostMapping(DEPOSIT)
    public void createDeposit(@RequestBody DepositDto depositDto) {
        depositService.createDeposit(depositDto);
    }

    @GetMapping(DEPOSIT_CLOSE)
    public void closeDay(@RequestParam Integer monthAmount) {
        depositService.closeDay(monthAmount);
    }
}