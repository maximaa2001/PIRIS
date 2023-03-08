package by.bsuir.bankSystem.entity.dto.card;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MoneyDto {
    private BigDecimal money;
}
