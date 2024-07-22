package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @ManyToOne
    private Class aClass;

    public Student(int age, Class aClass, Long id, String name) {
        this.age = age;
        this.aClass = aClass;
        this.id = id;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Class getClasses() {
        return aClass;
    }

    public void setClasses(Class aClass) {
        this.aClass = aClass;
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

    public Student() {

    }
}
