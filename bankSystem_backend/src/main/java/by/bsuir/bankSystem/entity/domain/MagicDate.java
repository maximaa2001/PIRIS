package by.bsuir.bankSystem.entity.domain;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "magic_date")
@Data
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class MagicDate {

    @Id
    @Column(name = "id")
    @ToString.Include
    private Integer id;

    @Column(name = "date")
    @ToString.Include
    private LocalDate date;
}
