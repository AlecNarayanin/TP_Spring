package com.ynov.tp_spring.dto;

import com.ynov.tp_spring.entities.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ProjectUpsertDTO implements Serializable {

    private Integer id;
    private String name;
    private Integer auteurId;
    private Date dateCreation;
    private Date dateCloture;
    private String keywords;

    public ProjectUpsertDTO() {
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

    public Integer getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Integer auteurId) {
        this.auteurId = auteurId;
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
}
