package com.ynov.tp_spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "contenu")
    private String contenu;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToMany(mappedBy = "comments")
    private List<User> users = new ArrayList<User>();

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Comment addUser(User usr){
        this.users.add(usr);
        return this;
    }

    public Comment removeUserById(Integer id){
        Integer indexUsr = IntStream.range(0, this.users.size()).filter(i -> id.equals(this.users.get(i))).findFirst().orElse(-1);
        if(indexUsr > -1){
            this.users.remove(indexUsr);
        }
        return this;
    }
}
