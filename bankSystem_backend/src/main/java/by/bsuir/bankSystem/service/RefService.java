package by.bsuir.bankSystem.service;

import by.bsuir.bankSystem.entity.dto.RefDto;

public interface RefService {
    RefDto getAllClientReferences();
    RefDto getAllDepositReferences();
}
