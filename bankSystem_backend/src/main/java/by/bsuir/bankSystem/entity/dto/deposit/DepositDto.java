package by.bsuir.bankSystem.entity.dto.deposit;

import by.bsuir.bankSystem.entity.domain.Deposit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositDto {
    private Integer depositType;
    private Integer contractNumber;
    private String currency;
    private String startDate;
    private String endDate;
    private String sum;
    private String percent;
    private Integer client;
    private String depositName;

    public static DepositDto miniOf(Deposit deposit) {
        DepositDto depositDto = new DepositDto();
        depositDto.setSum(deposit.getSum().toString());
        depositDto.setPercent(deposit.getPercent().toString());
        depositDto.setDepositName(deposit.getDepositType().getName());
        return depositDto;
    }
}
