package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TaskItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private TaskAssignment taskAssignment;

    public TaskItem(Long id, String name, TaskAssignment taskAssignment) {
        this.id = id;
        this.name = name;
        this.taskAssignment = taskAssignment;
    }

    public TaskItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskAssignment getTaskAssignment() {
        return taskAssignment;
    }

    public void setTaskAssignment(TaskAssignment taskAssignment) {
        this.taskAssignment = taskAssignment;
    }

}
