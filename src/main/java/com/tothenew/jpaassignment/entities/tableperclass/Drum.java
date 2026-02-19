package com.tothenew.jpaassignment.entities.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class Drum extends Instrument {
    private int drumSize;
    private boolean isAcoustic;

    public Drum() {
    }

    public Drum(int drumSize, boolean isAcoustic) {
        this.drumSize = drumSize;
        this.isAcoustic = isAcoustic;
    }

    public int getDrumSize() {
        return drumSize;
    }

    public void setDrumSize(int drumSize) {
        this.drumSize = drumSize;
    }

    public boolean isAcoustic() {
        return isAcoustic;
    }

    public void setAcoustic(boolean acoustic) {
        isAcoustic = acoustic;
    }
}