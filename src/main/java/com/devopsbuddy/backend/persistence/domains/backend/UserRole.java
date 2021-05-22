package com.devopsbuddy.backend.persistence.domains.backend;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserRole implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_Id")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_Id")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;

        if(!user.equals(userRole.user)) return false;
        return role.equals(userRole.role);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31*result+role.hashCode();
        return result;
    }
}
