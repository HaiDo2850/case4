package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TeamDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    @ManyToOne
    private User user;
    @ManyToOne
    private Team team;

    public TeamDetail(Long id, User user, Team team) {
        this.id = id;
        this.user = user;
        this.team = team;
    }

    public TeamDetail() {

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
