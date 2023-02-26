package by.bsuir.bankSystem.entity.dto.city;

import by.bsuir.bankSystem.entity.domain.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CityListDto {
    private List<CityDto> cities;

    public static CityListDto of(List<City> cities) {
        return new CityListDto(cities.stream().map(CityDto::of).collect(Collectors.toList()));
    }
}
