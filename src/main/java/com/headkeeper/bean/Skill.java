package com.headkeeper.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "skill", schema = "head_keepers")
public class Skill implements Serializable {
    private int id;
    private String name;
    private byte level;
    private Set<User> users;
    private Set<Vacancy> vacancies;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 90)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (id != skill.id) return false;
        if (level != skill.level) return false;
        if (name != null ? !name.equals(skill.name) : skill.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) level;
        return result;
    }

    @ManyToMany
    @JoinTable(name = "skill_to_user", catalog = "", schema = "head_keepers", joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false))
    @JsonBackReference
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany
    @JoinTable(name = "skill_to_vacancy", catalog = "", schema = "head_keepers", joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "vacancy_id", referencedColumnName = "id", nullable = false))
    @JsonBackReference
    public Set<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(Set<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", users=" + users +
                ", vacancies=" + vacancies +
                '}';
    }
}