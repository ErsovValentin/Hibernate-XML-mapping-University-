package com.hibernate.hbm.univesity;

import java.util.HashSet;
import java.util.Set;

public class Groups {
    private int id;
    private String name;
    private Faculty faculty;
    private Set<Students>students;
    private Set<Professors>professors;

    public Groups() {
        name = null;
        faculty = null;
        students = new HashSet<Students>();
        professors = new HashSet<Professors>();
    }

    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty=" + faculty +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public Set<Students> getStudents() {
        return students;
    }

    public Set<Professors> getProfessors() {
        return professors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setStudents(Set<Students> students) {
        this.students = students;
    }

    public void setProfessors(Set<Professors> professors) {
        this.professors = professors;
    }
}
