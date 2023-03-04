package by.bsuir.bankSystem.entity.domain;


import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "currency_ref")
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class Currency {

    @Id
    @Column(name = "iso")
    @ToString.Include
    private String iso;

    @NotNull
    @Column(name = "name")
    @ToString.Include
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return iso.equals(currency.iso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iso);
    }
}
