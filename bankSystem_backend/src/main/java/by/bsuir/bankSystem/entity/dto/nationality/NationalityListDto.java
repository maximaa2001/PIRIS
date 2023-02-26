package by.bsuir.bankSystem.entity.dto.nationality;

import by.bsuir.bankSystem.entity.domain.Nationality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NationalityListDto {
    private List<NationalityDto> nationalities;

    public static NationalityListDto of(List<Nationality> nationalities) {
        return new NationalityListDto(nationalities.stream().map(NationalityDto::of).collect(Collectors.toList()));
    }
}
