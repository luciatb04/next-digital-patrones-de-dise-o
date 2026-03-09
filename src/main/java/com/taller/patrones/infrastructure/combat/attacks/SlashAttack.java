package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public class SlashAttack implements AttackFactory {
    @Override
    public Attack createAttack() {
        return new Attack("Slash", 55, Attack.AttackType.NORMAL );
    }
}
