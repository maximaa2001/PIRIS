package by.bsuir.bankSystem.entity.domain;

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

    @NotNull
    @NotEmpty()
    @Pattern(regexp = "[^0-9].")
    @Column(name = "surname")
    private String surname;
    @NotNull
    @NotEmpty()
    @Pattern(regexp = "[^0-9].")
    @Column(name = "name")
    private String name;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[^0-9].")
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "date_birth")
    private Date dateBirth;

    @NotNull
    @Length(min = 2, max = 2)
    @Pattern(regexp = "[A-Z]{2}")
    @Column(name = "part_passport")
    private String partPassport;

    @NotNull
    @Length(min = 7, max = 7)
    @Pattern(regexp = "[0-9]{7}")
    @Column(name = "number_passport")
    private String numberPassport;

    @NotNull
    @NotEmpty
    @Column(name = "source_passport")
    private String sourcePassport;

    @NotNull
    @Column(name = "start_date_passport")
    private Date startDatePassport;

    @NotNull
    @NotEmpty
    @Length(min = 14, max = 14)
    @Pattern(regexp = "[0-9]{7}[A-Z]{1}[0-9]{3}[A-Z]{2}[0-9]{1}")
    @Column(name = "identifier_number_passport")
    private String identifierNumberPassport;

    @NotNull
    @NotEmpty
    @Column(name = "place_birth")
    private String placeBirth;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_live_id", referencedColumnName = "id")
    private City cityLive;

    @NotNull
    @NotEmpty
    @Column(name = "address")
    private String address;

    @Length(min = 6, max = 6)
    @Pattern(regexp = "[0-9]{6}")
    @Column(name = "home_phone")
    private String homePhone;

    @Length(min = 12, max = 12)
    @Pattern(regexp = "[0-9]{12}")
    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "work")
    private String work;

    @Column(name = "position")
    private String position;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_registration_id", referencedColumnName = "id")
    private City cityRegistration;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "family_status_id", referencedColumnName = "id")
    private FamilyStatus familyStatus;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "nationality_id", referencedColumnName = "id")
    private Nationality nationality;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "disability_id", referencedColumnName = "id")
    private Disability disability;

    @NotNull
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
