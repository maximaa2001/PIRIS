package by.bsuir.bankSystem.entity.dto.currency;

import by.bsuir.bankSystem.entity.domain.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CurrencyDto {

    private String iso;
    private String name;

    public static CurrencyDto of(Currency currency) {
        return new CurrencyDto(currency.getIso(), currency.getName());
    }
}
