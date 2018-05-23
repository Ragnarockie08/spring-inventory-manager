package com.codecool.springinventorymanager.model;

import javax.persistence.*;

@Entity
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @OneToOne(mappedBy = "description", cascade=CascadeType.ALL)
    private Inventory item;

    public Description() {
    }

    public Description(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Inventory getItems() {
        return item;
    }

    public void setItems(Inventory item) {
        this.item = item;
    }
}
