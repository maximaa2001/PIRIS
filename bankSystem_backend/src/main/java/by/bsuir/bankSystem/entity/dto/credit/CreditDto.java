package by.bsuir.bankSystem.entity.dto.credit;

import by.bsuir.bankSystem.entity.domain.Credit;
import by.bsuir.bankSystem.entity.domain.Deposit;
import by.bsuir.bankSystem.entity.dto.deposit.DepositDto;
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
public class CreditDto {
    private Integer creditType;
    private Integer contractNumber;
    private String currency;
    private String startDate;
    private String endDate;
    private String sum;
    private String percent;
    private Integer client;
    private String creditName;

    public static CreditDto miniOf(Credit credit) {
        CreditDto creditDto = new CreditDto();
        creditDto.setSum(credit.getSum().toString());
        creditDto.setPercent(credit.getPercent().toString());
        creditDto.setCreditName(credit.getCreditType().getName());
        return creditDto;
    }
}
