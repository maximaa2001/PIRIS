package by.bsuir.bankSystem.entity.dto.card;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditMoney {
    private String number;
    private BigDecimal money;
}
