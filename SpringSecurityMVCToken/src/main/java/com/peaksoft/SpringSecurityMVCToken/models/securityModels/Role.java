package com.peaksoft.SpringSecurityMVCToken.models.securityModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(generator = "role_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_gen", sequenceName = "role_seq", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private Set<User> users;
}
