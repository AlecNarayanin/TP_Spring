package com.ynov.tp_spring.entities;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "contenu")
    private String contenu;

//    @ManyToMany
//    @JoinTable(name="likes_comment", @JoinColumn(name = "comment_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<>
}
