package com.ynov.tp_spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Enumerated()
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "auteur")
    private List<Project> projects;

    public enum Role {
        MEDECIN, CHERCHEUR
    }
}
