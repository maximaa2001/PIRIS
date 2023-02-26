package by.bsuir.bankSystem.entity.dto.city;

import by.bsuir.bankSystem.entity.domain.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CityDto {
    private Integer id;
    private String name;

    public static CityDto of(City city) {
        return new CityDto(city.getId(), city.getName());
    }
}
