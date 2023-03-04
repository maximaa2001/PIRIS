package by.bsuir.bankSystem.entity.dto.depositType;

import by.bsuir.bankSystem.entity.domain.DepositType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DepositTypeDto {

    private Integer id;
    private String name;

    public static DepositTypeDto of(DepositType depositType) {
        return new DepositTypeDto(depositType.getId(), depositType.getName());
    }
}
