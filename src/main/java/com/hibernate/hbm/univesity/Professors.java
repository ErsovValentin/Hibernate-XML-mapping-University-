package com.hibernate.hbm.univesity;

import java.util.HashSet;
import java.util.Set;

public class Professors {
    private int id;
    private String name;
    private int experience;
    private Set<Groups> groups;

    public Professors() {
        name = null;
        experience = -1;
        groups = new HashSet<Groups>();
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public Set<Groups> getGroups() {
        return groups;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setGroups(Set<Groups> groups) {
        this.groups = groups;
    }
}
