package by.bsuir.bankSystem.entity.dto;

import by.bsuir.bankSystem.entity.dto.city.CityDto;
import by.bsuir.bankSystem.entity.dto.client.ClientDto;
import by.bsuir.bankSystem.entity.dto.currency.CurrencyDto;
import by.bsuir.bankSystem.entity.dto.depositType.DepositTypeDto;
import by.bsuir.bankSystem.entity.dto.disability.DisabilityDto;
import by.bsuir.bankSystem.entity.dto.familyStatus.FamilyStatusDto;
import by.bsuir.bankSystem.entity.dto.nationality.NationalityDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RefDto {
    private List<CityDto> cities;
    private List<DisabilityDto> disabilities;
    private List<FamilyStatusDto> familyStatuses;
    private List<NationalityDto> nationalities;
    private List<DepositTypeDto> depositTypes;
    private List<CurrencyDto> currencies;
    private List<ClientDto> clients;

    public RefDto(List<CityDto> cities, List<DisabilityDto> disabilities, List<FamilyStatusDto> familyStatuses, List<NationalityDto> nationalities) {
        this.cities = cities;
        this.disabilities = disabilities;
        this.familyStatuses = familyStatuses;
        this.nationalities = nationalities;
    }

    public RefDto(List<DepositTypeDto> depositTypes, List<CurrencyDto> currencies, List<ClientDto> clients) {
        this.depositTypes = depositTypes;
        this.currencies = currencies;
        this.clients = clients;
    }
}
