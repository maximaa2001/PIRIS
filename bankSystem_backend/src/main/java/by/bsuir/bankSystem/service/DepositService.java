package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.entity.dto.deposit.DepositDto;

public interface DepositService {
    void createDeposit(DepositDto depositDto);
    void closeDay(int monthAmount);
}
