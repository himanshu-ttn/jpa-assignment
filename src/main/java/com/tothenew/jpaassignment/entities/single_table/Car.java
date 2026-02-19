package com.tothenew.jpaassignment.entities.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("car")
public class Car extends Vehicle {
    private int seats;
    private boolean sunroof;

    public Car() {
    }

    public Car(int seats, boolean sunroof) {
        this.seats = seats;
        this.sunroof = sunroof;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }
}