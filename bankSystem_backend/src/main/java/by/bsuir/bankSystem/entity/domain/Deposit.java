package by.bsuir.bankSystem.entity.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "deposit")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ToString.Include
    private Integer id;

    @ManyToOne
    @NotNull(message = "depositType not empty")
    @JoinColumn(name = "deposit_type", referencedColumnName = "id")
    private DepositType depositType;

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
        Deposit deposit = (Deposit) o;
        return id.equals(deposit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
