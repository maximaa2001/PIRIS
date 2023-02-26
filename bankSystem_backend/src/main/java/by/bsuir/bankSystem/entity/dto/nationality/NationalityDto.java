package by.bsuir.bankSystem.entity.dto.nationality;

import by.bsuir.bankSystem.entity.domain.Nationality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NationalityDto {
    private Integer id;
    private String name;

    public static NationalityDto of(Nationality nationality) {
        return new NationalityDto(nationality.getId(), nationality.getName());
    }
}
