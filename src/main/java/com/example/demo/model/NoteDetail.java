package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class NoteDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Tag tag;
    @ManyToOne
    private Note note;
    private String status;

    public NoteDetail() {
    }

    public NoteDetail(Long id, Tag tag, Note note, String status) {
        this.id = id;
        this.tag = tag;
        this.note = note;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
