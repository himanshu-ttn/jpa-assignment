package com.tothenew.jpaassignment.entities.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class Guitar extends Instrument {
    private int numberOfStrings;
    private boolean isElectric;

    public Guitar() {
    }

    public Guitar(int numberOfStrings, boolean isElectric) {
        this.numberOfStrings = numberOfStrings;
        this.isElectric = isElectric;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }
}