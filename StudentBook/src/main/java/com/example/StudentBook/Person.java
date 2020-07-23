package com.example.StudentBook;

import javax.persistence.*;

@Entity
@Table(name="KsiegaStudentow")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    @Column(name = "numer_indeksu", nullable = false)
    private String indeks;
    private String email;
    @Column(length = 2048)
    private String description;
    @Transient
    boolean newU;

    public Person(String firstname, String lastname, String indeks, String email, String description, boolean newU) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.indeks = indeks;
        this.email = email;
        this.description = description;
        this.newU = newU;
    }

    public Person(){
    }

    public Person(Long id, String firstname, String lastname, String indeks, String email, String description, boolean newU) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.indeks = indeks;
        this.email = email;
        this.description = description;
        this.newU = newU;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNewU() {
        return newU;
    }

    public void setNewU(boolean newU) {
        this.newU = newU;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", indeks='" + indeks + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", newU=" + newU +
                '}';
    }
}
