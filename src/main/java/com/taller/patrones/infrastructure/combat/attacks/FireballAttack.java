package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public class FireballAttack implements  AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Fireball", 80, Attack.AttackType.SPECIAL);
    }
}
