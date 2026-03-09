package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public class TackleAttack implements AttackFactory {

    @Override
    public Attack createAttack() {
        return new Attack("Tackle", 40, Attack.AttackType.NORMAL);
    }

}
