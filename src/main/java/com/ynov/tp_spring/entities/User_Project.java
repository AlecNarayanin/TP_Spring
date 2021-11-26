package com.ynov.tp_spring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class User_Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
    @Enumerated()
    @Column(name = "type")
    private Type type;
    @Enumerated()
    @Column(name = "status")
    private Status status;

    public User_Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public enum Type {
        PARTICIPANT, SUBSCRIBER
    }

    public enum Status {
        WAITING, REFUSED, ACCEPTED
    }
}
