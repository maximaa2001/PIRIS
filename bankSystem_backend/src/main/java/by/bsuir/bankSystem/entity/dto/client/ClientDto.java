package by.bsuir.bankSystem.entity.dto.client;

import by.bsuir.bankSystem.entity.domain.Client;
import by.bsuir.bankSystem.util.Validator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {
    private Integer id;
    private String surname;
    private String name;
    private String lastName;
    private String dateBirth;
    private String partPassport;
    private String numberPassport;
    private String sourcePassport;
    private String startDatePassport;
    private String identifierNumberPassport;
    private String placeBirth;
    @JsonProperty("cityLive")
    private Integer cityLiveId;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String work;
    private String position;
    @JsonProperty("cityRegistration")
    private Integer cityRegistrationId;
    @JsonProperty("familyStatus")
    private Integer familyStatusId;
    @JsonProperty("nationality")
    private Integer nationalityId;
    @JsonProperty("disability")
    private Integer disabilityId;
    private Boolean isPensioner;
    private String salaryMonth;

    public static ClientDto of(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .surname(client.getSurname())
                .name(client.getName())
                .lastName(client.getLastName())
                .dateBirth(Validator.dateToString(client.getDateBirth()))
                .partPassport(client.getPartPassport())
                .numberPassport(client.getNumberPassport())
                .sourcePassport(client.getSourcePassport())
                .startDatePassport(Validator.dateToString(client.getStartDatePassport()))
                .identifierNumberPassport(client.getIdentifierNumberPassport())
                .placeBirth(client.getPlaceBirth())
                .cityLiveId(client.getCityLive().getId())
                .address(client.getAddress())
                .homePhone(client.getHomePhone())
                .mobilePhone(client.getMobilePhone())
                .email(client.getEmail())
                .work(client.getWork())
                .position(client.getPosition())
                .cityRegistrationId(client.getCityRegistration().getId())
                .familyStatusId(client.getFamilyStatus().getId())
                .nationalityId(client.getNationality().getId())
                .disabilityId(client.getDisability().getId())
                .isPensioner(client.getIsPensioner())
                .salaryMonth((client.getSalaryMonth() != null) ? client.getSalaryMonth().toString() : null)
                .build();
    }

    public static ClientDto miniOf(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .surname(client.getSurname())
                .name(client.getName())
                .lastName(client.getLastName())
                .partPassport(client.getPartPassport())
                .numberPassport(client.getNumberPassport())
                .build();
    }
}
