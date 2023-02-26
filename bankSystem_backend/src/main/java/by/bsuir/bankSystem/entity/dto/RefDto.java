package by.bsuir.bankSystem.entity.dto;

import by.bsuir.bankSystem.entity.dto.city.CityDto;
import by.bsuir.bankSystem.entity.dto.disability.DisabilityDto;
import by.bsuir.bankSystem.entity.dto.familyStatus.FamilyStatusDto;
import by.bsuir.bankSystem.entity.dto.nationality.NationalityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RefDto {
    private List<CityDto> cities;
    private List<DisabilityDto> disabilities;
    private List<FamilyStatusDto> familyStatuses;
    private List<NationalityDto> nationalities;
}
