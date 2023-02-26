package by.bsuir.bankSystem.entity.dto.familyStatus;

import by.bsuir.bankSystem.entity.domain.FamilyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FamilyStatusListDto {
    private List<FamilyStatusDto> familyStatuses;

    public static FamilyStatusListDto of(List<FamilyStatus> familyStatuses) {
        return new FamilyStatusListDto(familyStatuses.stream().map(FamilyStatusDto::of).collect(Collectors.toList()));
    }
}
