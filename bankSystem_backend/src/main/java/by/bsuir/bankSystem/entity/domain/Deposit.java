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
    @Column(name = "id")
    @ToString.Include
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "deposit_type", referencedColumnName = "id")
    private DepositType depositType;

    @NotNull
    @Pattern(regexp = "[0-9]{13}")
    @Column(name = "contract_number")
    private Integer contractNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "currency_iso", referencedColumnName = "id")
    private Currency currency;

    @NotNull
    @Column(name = "contract_term")
    private Integer contractTerm;

    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @Future
    @Column(name = "endDate")
    private LocalDate endDate;

    @NotNull
    @Column(name = "sum")
    private BigDecimal sum;

    @NotNull
    @Column(name = "percent")
    private Double percent;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @OneToOne
    @JoinColumn(name = "current_account_id", nullable = false)
    private BankAccount currentAccount;

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
