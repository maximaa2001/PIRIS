package by.bsuir.bankSystem.entity.domain;

import by.bsuir.bankSystem.util.NullOrPattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "clients")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Integer id;

    @Pattern(regexp = "[a-zA-Z]+", message = "surname [a-zA-Z]+")
    @Column(name = "surname")
    private String surname;
    @Pattern(regexp = "[a-zA-Z]+", message = "name [a-zA-Z]+")
    @Column(name = "name")
    private String name;

    @Pattern(regexp = "[a-zA-Z]+", message = "lastName [a-zA-Z]+")
    @Column(name = "last_name")
    private String lastName;

    @Past(message = "dateBirth is not valid")
    @Column(name = "date_birth")
    private Date dateBirth;

    @Pattern(regexp = "[A-Z]{2}", message = "lastName [A-Z]{2}")
    @Column(name = "part_passport")
    private String partPassport;

    @Pattern(regexp = "[0-9]{7}", message = "numberPassport [0-9]{7}")
    @Column(name = "number_passport")
    private String numberPassport;

    @NotEmpty(message = "sourcePassport not empty")
    @Column(name = "source_passport")
    private String sourcePassport;

    @Past(message = "startDatePassport is not valid")
    @Column(name = "start_date_passport")
    private Date startDatePassport;

    @Pattern(regexp = "[0-9]{7}[A-Z]{1}[0-9]{3}[A-Z]{2}[0-9]{1}", message = "identifierNumberPassport [0-9]{7}[A-Z]{1}[0-9]{3}[A-Z]{2}[0-9]{1}")
    @Column(name = "identifier_number_passport")
    private String identifierNumberPassport;

    @NotEmpty(message = "placeBirth not empty")
    @Column(name = "place_birth")
    private String placeBirth;

    @NotNull(message = "cityLive required")
    @ManyToOne
    @JoinColumn(name = "city_live_id", referencedColumnName = "id")
    private City cityLive;

    @NotEmpty(message = "address not empty")
    @Column(name = "address")
    private String address;

    @NullOrPattern(pattern = "[0-9]{6}", message = "homePhone [0-9]{6}")
    @Column(name = "home_phone")
    private String homePhone;

    @NullOrPattern(pattern = "[0-9]{12}", message = "mobilePhone [0-9]{12}")
    @Column(name = "mobile_phone")
    private String mobilePhone;

    @NullOrPattern(pattern =  "^([\\w_\\-\\.])+@[\\w\\-\\.]+\\.([A-Za-z]{2,5})$", message = "email")
    @Column(name = "email")
    private String email;

    @Column(name = "work")
    private String work;

    @Column(name = "position")
    private String position;

    @NotNull(message = "cityRegistration required")
    @ManyToOne
    @JoinColumn(name = "city_registration_id", referencedColumnName = "id")
    private City cityRegistration;

    @NotNull(message = "familyStatus required")
    @ManyToOne
    @JoinColumn(name = "family_status_id", referencedColumnName = "id")
    private FamilyStatus familyStatus;

    @NotNull(message = "nationality required")
    @ManyToOne
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    private Nationality nationality;

    @NotNull(message = "disability required")
    @ManyToOne
    @JoinColumn(name = "disability_id", referencedColumnName = "id")
    private Disability disability;

    @NotNull(message = "isPensioner required")
    @Column(name = "is_pensioner")
    private Boolean isPensioner;

    @Column(name = "salary_month")
    private BigDecimal salaryMonth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
