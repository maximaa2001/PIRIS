package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.entity.dto.deposit.DepositDto;
import by.bsuir.bankSystem.entity.dto.deposit.DepositListDto;

import java.util.List;

public interface DepositService {
    DepositListDto findAll();
    void createDeposit(DepositDto depositDto);
    void closeDay(int monthAmount);
}
