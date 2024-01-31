package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Note note;
    @ManyToOne
    private User user;
    @ManyToOne
    private TaskItem taskItem;

    public TsDetail(Long id, Team team, Note note, User user, TaskItem taskItem) {
        this.id = id;
        this.team = team;
        this.note = note;
        this.user = user;
        this.taskItem = taskItem;
    }

    public TsDetail() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskItem getTaskItem() {
        return taskItem;
    }

    public void setTaskItem(TaskItem taskItem) {
        this.taskItem = taskItem;
    }
}

