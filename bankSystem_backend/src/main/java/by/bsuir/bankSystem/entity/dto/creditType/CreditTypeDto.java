package by.bsuir.bankSystem.entity.dto.creditType;

import by.bsuir.bankSystem.entity.domain.CreditType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreditTypeDto {
    private Integer id;
    private String name;

    public static CreditTypeDto of(CreditType creditType) {
        return new CreditTypeDto(creditType.getId(), creditType.getName());
    }
}
