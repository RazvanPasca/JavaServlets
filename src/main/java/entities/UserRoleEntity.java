package entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role", schema = "assignment-one")
@Getter
@Setter
public class UserRoleEntity {

    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "role")
    private String role;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private UserEntity userEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleEntity that = (UserRoleEntity) o;
        return id == that.id &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, role);
    }
}
