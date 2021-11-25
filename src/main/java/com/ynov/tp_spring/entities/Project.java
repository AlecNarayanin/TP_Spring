package com.ynov.tp_spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class Project implements Serializable {

    public Project(){}

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAuteur() {
        return auteur;
    }

    public void setAuteur(User auteur) {
        this.auteur = auteur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<User> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(List<User> abonnes) {
        this.abonnes = abonnes;
    }
}
