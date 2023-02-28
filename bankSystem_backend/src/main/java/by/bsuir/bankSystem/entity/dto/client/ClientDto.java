package by.bsuir.bankSystem.entity.dto.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
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
}
