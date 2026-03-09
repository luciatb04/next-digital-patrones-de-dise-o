package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public class GolpeAttack implements  AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Golpe", 30, Attack.AttackType.NORMAL);
    }
}
