package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public class MeteoroAttack implements  AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Meteoro", 120, Attack.AttackType.SPECIAL);
    }
}
