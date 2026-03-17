package com.taller.patrones.domain;

import com.taller.patrones.infrastructure.combat.CombatEngine;

// Composite pattern
public interface AttackComponent {
    void execute(Character attacker, Character defender, Battle battle, CombatEngine engine);
}
