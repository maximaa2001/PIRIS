package by.bsuir.bankSystem.rest;

import by.bsuir.bankSystem.entity.dto.RefDto;
import by.bsuir.bankSystem.service.RefService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.bankSystem.constant.ApiPath.GET_CLIENT_REFERENCES;
import static by.bsuir.bankSystem.constant.ApiPath.GET_DEPOSIT_REFERENCES;

@RestController
public class RefRest {
    private final RefService refService;

    public RefRest(RefService refService) {
        this.refService = refService;
    }

    @GetMapping(value = GET_CLIENT_REFERENCES)
    public RefDto getAllClientReferences() {
        return refService.getAllClientReferences();
    }

    @GetMapping(value = GET_DEPOSIT_REFERENCES)
    public RefDto getAllDepositReferences() {
        return refService.getAllDepositReferences();
    }
}
