package by.bsuir.bankSystem.entity.dto.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private Integer cityLiveId;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String email;
    private String work;
    private String position;
    private Integer cityRegistrationId;
    private Integer familyStatusId;
    private Integer nationalityId;
    private Integer disabilityId;
    private Boolean isPensioner;
    private String salaryMonth;
}
