package by.bsuir.bankSystem.entity.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bank_card")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ToString.Include
    private Integer id;

    @Column(name = "number")
    private String number;

    @Column(name = "pin")
    private String pin;

    @OneToOne
    @JoinColumn(name = "deposit_id", referencedColumnName = "id")
    private Deposit deposit;

    @OneToOne
    @JoinColumn(name = "credit_id", referencedColumnName = "id")
    private Credit credit;
}
