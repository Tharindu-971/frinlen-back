package com.techscroll.frinlen.entity.user;

import com.techscroll.frinlen.entity.product.Product;
import com.techscroll.frinlen.entity.role.Role;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="user_role",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"))
    private List<Role> roles;
    @OneToMany(mappedBy = "createdBy")
    private List<Product> createdProducts;

    @OneToMany(mappedBy = "updatedBy")
    private List<Product> updatedProducts;
}
