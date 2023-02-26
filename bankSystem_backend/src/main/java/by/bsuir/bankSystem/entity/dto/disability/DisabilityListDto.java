package by.bsuir.bankSystem.entity.dto.disability;

import by.bsuir.bankSystem.entity.domain.Disability;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DisabilityListDto {
    private List<DisabilityDto> disabilities;

    public static DisabilityListDto of(List<Disability> disabilities) {
        return new DisabilityListDto(disabilities.stream().map(DisabilityDto::of).collect(Collectors.toList()));
    }
}
