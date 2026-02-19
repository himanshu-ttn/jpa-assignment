package com.tothenew.jpaassignment.entities.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class Piano extends Instrument {
    private int numberOfKeys;
    private boolean hasPedals;

    public Piano() {
    }

    public Piano(int numberOfKeys, boolean hasPedals) {
        this.numberOfKeys = numberOfKeys;
        this.hasPedals = hasPedals;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public boolean isHasPedals() {
        return hasPedals;
    }

    public void setHasPedals(boolean hasPedals) {
        this.hasPedals = hasPedals;
    }
}