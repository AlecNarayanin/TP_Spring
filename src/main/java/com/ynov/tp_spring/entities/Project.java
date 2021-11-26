package com.ynov.tp_spring.entities;

import com.ynov.tp_spring.dto.ProjectUpsertDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User auteur;
    @Column(name = "date_creation")
    private Date dateCreation;
    @Column(name = "date_cloture")
    private Date dateCloture;
    @Column(name = "keywords")
    private String keywords;
    @OneToMany(mappedBy = "project")
    private List<Comment> comment;
    @OneToMany(mappedBy = "project")
    private List<User_Project> userProject = new ArrayList<User_Project>();

    public Project() {
    }

    public Project(ProjectUpsertDTO dto){
        setFieldsWithDto(dto);
    }

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


    public Project mapUpsertDto(ProjectUpsertDTO dto){
        return  setFieldsWithDto(dto);
    }


    private Project setFieldsWithDto(ProjectUpsertDTO dto){
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setDateCloture(dto.getDateCloture());
        this.setDateCreation(dto.getDateCreation());
        this.setKeywords(dto.getKeywords());
        return this;
    }

}
