package by.bsuir.bankSystem.entity.dto.deposit;

import by.bsuir.bankSystem.entity.domain.Client;
import by.bsuir.bankSystem.entity.domain.Currency;
import by.bsuir.bankSystem.entity.domain.DepositType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositDto {
    private Integer depositType;
    private Integer contractNumber;
    private String currency;
    private Integer contractTerm;
    private String startDate;
    private String endDate;
    private String sum;
    private String percent;
    private Integer client;
}
