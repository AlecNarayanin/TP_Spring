package com.ynov.tp_spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    @Column(name = "auteur")
    private User auteur;

    @Column(name = "date_creation")
    private Date dateCreation;

    @Column(name = "date_cloture")
    private Date dateCloture;

    @Column(name = "keywords")
    private String keywords;

    @OneToMany(mappedBy = "id")
    @Column(name = "abonnes")
    private List<User> abonnes;





}
