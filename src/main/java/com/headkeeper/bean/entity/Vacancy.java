package com.headkeeper.bean.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "vacancy", schema = "head_keepers")
public class Vacancy {

    private int id;
    private String title;
    private String description;
    private String essentialSkills;
    private String preferableSkills;
    private String phoneNumber;
    private String email;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
    private String additionalInfoAboutSalary;
    private boolean isActive;
    private Set<Skill> skills;
    private User user;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 90)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "essential_skills", nullable = false)
    public String getEssentialSkills() {
        return essentialSkills;
    }

    public void setEssentialSkills(String essentialSkills) {
        this.essentialSkills = essentialSkills;
    }

    @Basic
    @Column(name = "preferable_skills", nullable = true)
    public String getPreferableSkills() {
        return preferableSkills;
    }

    public void setPreferableSkills(String preferableSkills) {
        this.preferableSkills = preferableSkills;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 90)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "min_salary", nullable = false, precision = 4)
    public BigDecimal getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "max_salary", nullable = true, precision = 4)
    public BigDecimal getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Basic
    @Column(name = "additional_info_about_salary", nullable = true, length = 255)
    public String getAdditionalInfoAboutSalary() {
        return additionalInfoAboutSalary;
    }

    public void setAdditionalInfoAboutSalary(String additionalInfoAboutSalary) {
        this.additionalInfoAboutSalary = additionalInfoAboutSalary;
    }

    @Basic
    @Column(name = "is_active", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacancy vacancy = (Vacancy) o;

        if (id != vacancy.id) return false;
        if (essentialSkills != vacancy.essentialSkills) return false;
        if (isActive != vacancy.isActive) return false;
        if (title != null ? !title.equals(vacancy.title) : vacancy.title != null) return false;
        if (description != null ? !description.equals(vacancy.description) : vacancy.description != null) return false;
        if (preferableSkills != null ? !preferableSkills.equals(vacancy.preferableSkills) : vacancy.preferableSkills != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(vacancy.phoneNumber) : vacancy.phoneNumber != null) return false;
        if (email != null ? !email.equals(vacancy.email) : vacancy.email != null) return false;
        if (minSalary != null ? !minSalary.equals(vacancy.minSalary) : vacancy.minSalary != null) return false;
        if (maxSalary != null ? !maxSalary.equals(vacancy.maxSalary) : vacancy.maxSalary != null) return false;
        if (additionalInfoAboutSalary != null ? !additionalInfoAboutSalary.equals(vacancy.additionalInfoAboutSalary) : vacancy.additionalInfoAboutSalary != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (preferableSkills != null ? preferableSkills.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (minSalary != null ? minSalary.hashCode() : 0);
        result = 31 * result + (maxSalary != null ? maxSalary.hashCode() : 0);
        result = 31 * result + (additionalInfoAboutSalary != null ? additionalInfoAboutSalary.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "vacancies", fetch = FetchType.EAGER)
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}