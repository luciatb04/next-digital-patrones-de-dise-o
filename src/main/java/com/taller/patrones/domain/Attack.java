package com.taller.patrones.domain;


/**
 * Representa un ataque que puede ejecutar un personaje.
 */
public class Attack {
    private final String name;
    private final int basePower;
    private final AttackType type;

    public Attack(String name, int basePower, AttackType type) {
        this.name = name;
        this.basePower = basePower;
        this.type = type;
    }

    public String getName() { return name; }
    public int getBasePower() { return basePower; }
    public AttackType getType() { return type; }

    public void execute(Character attacker, Character defender, Battle battle, int damage) {
        defender.takeDamage(damage);
        battle.log(attacker.getName() + " usa " + name + " y hace " + damage + " de daño a " + defender.getName());
    }

    public enum AttackType {
        NORMAL, SPECIAL, STATUS, CRITICO
    }
}


