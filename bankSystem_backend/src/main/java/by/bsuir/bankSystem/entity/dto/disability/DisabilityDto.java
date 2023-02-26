package by.bsuir.bankSystem.entity.dto.disability;

import by.bsuir.bankSystem.entity.domain.Disability;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DisabilityDto {

    private Integer id;
    private String name;

    public static DisabilityDto of(Disability disability) {
        return new DisabilityDto(disability.getId(), disability.getName());
    }
}
