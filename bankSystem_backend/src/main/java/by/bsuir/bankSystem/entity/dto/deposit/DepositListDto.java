package by.bsuir.bankSystem.entity.dto.deposit;

import by.bsuir.bankSystem.entity.domain.Deposit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DepositListDto {

    private List<DepositDto> deposits;

    public static DepositListDto of(List<Deposit> deposits) {
        return new DepositListDto(deposits.stream().map(DepositDto::miniOf).collect(Collectors.toList()));
    }
}
