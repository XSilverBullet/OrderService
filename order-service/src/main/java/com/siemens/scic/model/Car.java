package com.siemens.scic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Simon.Lau on 16-Dec-16.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonIgnore
    private int id;

    @Column(name = "color", nullable = false)
    private int color;

    @Column(name = "size", nullable = false)
    private int size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
