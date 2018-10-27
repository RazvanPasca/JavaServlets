package entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cities", schema = "flights-schema")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "lattitude")
    private double lattitude;
    @Basic
    @Column(name = "longitude")
    private double longitude;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return id == that.id &&
                Double.compare(that.lattitude, lattitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lattitude, longitude);
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "name='" + name + '\'' +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                '}';
    }
}
