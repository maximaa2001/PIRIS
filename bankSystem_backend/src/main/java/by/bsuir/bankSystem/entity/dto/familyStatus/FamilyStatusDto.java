package by.bsuir.bankSystem.entity.dto.familyStatus;

import by.bsuir.bankSystem.entity.domain.FamilyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FamilyStatusDto {
    private Integer id;
    private String name;

    public static FamilyStatusDto of(FamilyStatus familyStatus) {
        return new FamilyStatusDto(familyStatus.getId(), familyStatus.getName());
    }
}
