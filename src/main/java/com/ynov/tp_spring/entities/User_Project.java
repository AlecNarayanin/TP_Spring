package com.ynov.tp_spring.entities;

import javax.persistence.*;

@Entity
public class User_Project {

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



    public enum Type {
        PARTICIPANT, SUBSCRIBER
    }

    public enum Status {
        WAITING, REFUSED, ACCEPTED
    }
}
