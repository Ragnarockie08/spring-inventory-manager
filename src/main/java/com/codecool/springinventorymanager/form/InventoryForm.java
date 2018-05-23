package com.codecool.springinventorymanager.form;

import java.math.BigInteger;

public class InventoryForm {

        private String name;

        private String text;

        private String manufacturer;

        private String category;

        private BigInteger cost;

        private String buyingDate;

        private String status;

        private Long owner;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

    public String getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(String buyingDate) {
        this.buyingDate = buyingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }
}
