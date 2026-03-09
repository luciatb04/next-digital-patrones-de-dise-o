package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public class PoisonStingAttack implements  AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Poison Sting", 20, Attack.AttackType.STATUS);
    }
}
