package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public class ThunderAttack implements  AttackFactory{
    @Override
    public Attack createAttack() {
        return new Attack("Thunder", 90, Attack.AttackType.SPECIAL);
    }
}
