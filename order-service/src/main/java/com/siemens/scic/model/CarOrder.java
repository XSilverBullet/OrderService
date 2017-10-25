package com.siemens.scic.model;

import javax.persistence.*;

/**
 * Created by Simon.Lau on 16-Dec-16.
 */
@Entity
@Table(name = "car_order")
public class CarOrder {

    @Id
    private String id;

    @Column(name = "state", nullable = false)
    private int state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
