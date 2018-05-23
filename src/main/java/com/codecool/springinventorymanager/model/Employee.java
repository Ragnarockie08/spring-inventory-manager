package com.codecool.springinventorymanager.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
    private Set<Inventory> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toShort(){

        return this.getFirstName() + " " + this.getLastName();
    }
}
