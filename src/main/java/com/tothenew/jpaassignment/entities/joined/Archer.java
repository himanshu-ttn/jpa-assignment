package com.tothenew.jpaassignment.entities.joined;

import jakarta.persistence.Entity;

@Entity
public class Archer extends GameCharacter {
    private int agility;
    private int arrowCount;

    public Archer() {

    }

    public Archer(Long id, String name, int level, int agility) {
        super(id, name, level);
        this.agility = agility;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }
}
