package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "flights-schema")
public class UserEntity {
    private String name;
    private String password;
    private int id;

    public UserEntity() {
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, id);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
