package com.ynov.tp_spring.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "requests")
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private RequestStatus status;
    @ManyToOne
    @JoinColumn(name="project_id", nullable=false)
    private Project project;


    public Request() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public enum RequestStatus {
        PENDING, ACCEPTED, DECLINED
    }
}
