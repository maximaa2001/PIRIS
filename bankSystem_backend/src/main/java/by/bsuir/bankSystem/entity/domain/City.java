package by.bsuir.bankSystem.entity.domain;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "cities_ref")
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class City {

    @Id
    @Column(name = "id")
    @ToString.Include
    private Integer id;

    @NotNull
    @Column(name = "name")
    @ToString.Include
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id.equals(city.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
