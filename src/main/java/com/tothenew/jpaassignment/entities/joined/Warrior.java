package com.tothenew.jpaassignment.entities.joined;

import jakarta.persistence.Entity;

@Entity
public class Warrior extends GameCharacter {
    private int strength;
    private String weaponType;

    public Warrior() {
    }

    public Warrior(Long id, String name, int level, int strength, String weaponType) {
        super(id, name, level);
        this.strength = strength;
        this.weaponType = weaponType;
    }

// getters & setters

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }
}
