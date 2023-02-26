package by.bsuir.bankSystem.entity.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "clients")
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    private Integer id;

    @NotNull
    @Column(name = "surname")
    private String surname;
    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "date_birth")
    private Date dateBirth;

    @NotNull
    @Column(name = "part_passport")
    private String partPassport;

    @NotNull
    @Column(name = "number_passport")
    private String numberPassport;

    @NotNull
    @Column(name = "source_passport")
    private String sourcePassport;

    @NotNull
    @Column(name = "start_date_passport")
    private Date startDatePassport;

    @NotNull
    @Column(name = "identifier_number_passport")
    private String identifierNumberPassport;

    @NotNull
    @Column(name = "place_birth")
    private String placeBirth;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_live_id", referencedColumnName = "id")
    private City cityLive;

    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "mobile_phone")
    private String mobilePhone;

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
