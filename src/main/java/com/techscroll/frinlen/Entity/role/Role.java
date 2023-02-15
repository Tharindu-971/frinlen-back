package com.techscroll.frinlen.entity.role;

import com.techscroll.frinlen.entity.user.User;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleName role;

    @ManyToMany(mappedBy="roles", cascade= CascadeType.ALL)
    private List<User> users;

    public Role(RoleName roleUser) {
        this.role = roleUser;
    }
}

