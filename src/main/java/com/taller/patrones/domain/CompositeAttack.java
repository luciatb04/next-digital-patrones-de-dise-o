package com.taller.patrones.domain;

import com.taller.patrones.infrastructure.combat.CombatEngine;

// Composite attack
public class CompositeAttack implements AttackComponent {
    private final java.util.List<AttackComponent> attacks;

    public CompositeAttack(java.util.List<AttackComponent> attacks) {
        this.attacks = attacks;
    }

    @Override
    public void execute(Character attacker, Character defender, Battle battle, CombatEngine engine) {
        for (AttackComponent ac : attacks) {
            ac.execute(attacker, defender, battle, engine);
        }
    }
}
