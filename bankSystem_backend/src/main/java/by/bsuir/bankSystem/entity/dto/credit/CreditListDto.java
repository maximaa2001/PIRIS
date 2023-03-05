package by.bsuir.bankSystem.entity.dto.credit;

import by.bsuir.bankSystem.entity.domain.Credit;
import by.bsuir.bankSystem.entity.domain.Deposit;
import by.bsuir.bankSystem.entity.dto.deposit.DepositDto;
import by.bsuir.bankSystem.entity.dto.deposit.DepositListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreditListDto {

    private List<CreditDto> credits;

    public static CreditListDto of(List<Credit> credits) {
        return new CreditListDto(credits.stream().map(CreditDto::miniOf).collect(Collectors.toList()));
    }
}
