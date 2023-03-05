package by.bsuir.bankSystem.entity.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "credit")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ToString.Include
    private Integer id;

    @ManyToOne
    @NotNull(message = "depositType not empty")
    @JoinColumn(name = "credit_type", referencedColumnName = "id")
    private CreditType creditType;

    @NotNull(message = "contractNumber not empty")
    @Column(name = "contract_number")
    private Integer contractNumber;

    @NotNull(message = "currency not empty")
    @ManyToOne
    @JoinColumn(name = "currency_iso", referencedColumnName = "iso")
    private Currency currency;

    @NotNull(message = "startDate not empty")
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull(message = "endDate not empty")
    @Future(message = "endDate future")
    @Column(name = "endDate")
    private LocalDate endDate;

    @NotNull(message = "sum not empty")
    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "percent")
    private Double percent;

    @NotNull(message = "client not empty")
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @NotNull
    @OneToOne
    @JoinColumn(name = "current_account_id", nullable = false)
    private BankAccount currentAccount;

    @NotNull
    @OneToOne
    @JoinColumn(name = "percent_account_id", nullable = false)
    private BankAccount percentAccount;

    @Column(name = "is_open")
    private Boolean isOpen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return id.equals(credit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
