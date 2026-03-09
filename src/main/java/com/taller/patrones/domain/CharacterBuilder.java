package com.taller.patrones.domain;

public class CharacterBuilder {
    public String name;
    public int currentHp;
    public int maxHp;
    public int attack;
    public int defense;
    public int speed;

    public CharacterBuilder name(String name){
        this.name = name;
        return this;
    }
    public CharacterBuilder currentHp(int currentHp){
        this.currentHp = currentHp;
        return this;
    }
    public CharacterBuilder maxHp(int maxHp){
        this.maxHp = maxHp;
        return this;
    }
    public CharacterBuilder attack(int attack){
        this.attack = attack;
        return this;
    }
    public CharacterBuilder defense(int defense){
        this.defense = defense;
        return this;
    }
    public CharacterBuilder speed(int speed){
        this.speed = speed;
        return this;
    }
    public Character build() {
        return new Character(this);
    }

}
