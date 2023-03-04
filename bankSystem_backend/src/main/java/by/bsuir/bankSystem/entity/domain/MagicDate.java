package by.bsuir.bankSystem.entity.domain;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "magic_date")
@Data
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class MagicDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ToString.Include
    private Integer id;

    @Column(name = "date")
    @ToString.Include
    private LocalDate date;
}
