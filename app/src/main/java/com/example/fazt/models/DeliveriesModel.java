package com.example.fazt.models;

public class DeliveriesModel {

    private String custumer, description, direction, daliveryDate, item, title;

    private DeliveriesModel() {

    }

    public DeliveriesModel(String custumer, String description, String direction, String daliveryDate, String item, String title) {
        this.custumer = custumer;
        this.description = description;
        this.direction = direction;
        this.daliveryDate  = daliveryDate;
        this.item = item;
        this.title = title;
    }

    public String getCustumer() {
        return custumer;
    }

    public void setCustumer(String custumer) {
        this.custumer = custumer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDaliveryDate() {
        return daliveryDate;
    }

    public void setDaliveryDate(String daliveryDate) {
        this.daliveryDate = daliveryDate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
