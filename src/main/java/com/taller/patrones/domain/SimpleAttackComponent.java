package com.taller.patrones.domain;

import com.taller.patrones.infrastructure.combat.CombatEngine;

public class SimpleAttackComponent implements AttackComponent {
    private final Attack attack;

    public SimpleAttackComponent(Attack attack) {
        this.attack = attack;
    }

    @Override
    public void execute(Character attacker, Character defender, Battle battle, CombatEngine engine) {
        int damage = engine.calculateDamage(attacker, defender, attack);
        attack.execute(attacker, defender, battle, damage);
    }
}
