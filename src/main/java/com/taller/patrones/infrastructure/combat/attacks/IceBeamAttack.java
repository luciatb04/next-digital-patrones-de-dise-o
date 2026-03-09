package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public class IceBeamAttack implements  AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Ice Beam", 70, Attack.AttackType.SPECIAL);
    }
}
