package by.bsuir.bankSystem.rest;

import by.bsuir.bankSystem.entity.dto.RefDto;
import by.bsuir.bankSystem.service.RefService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static by.bsuir.bankSystem.constant.ApiPath.GET_REFERENCES;

@RestController
public class RefRest {
    private final RefService refService;

    public RefRest(RefService refService) {
        this.refService = refService;
    }

    @GetMapping(value = GET_REFERENCES)
    public RefDto getAllReferences() {
        return refService.getAllReferences();
    }
}
