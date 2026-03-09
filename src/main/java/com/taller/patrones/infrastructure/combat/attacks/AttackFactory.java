package com.taller.patrones.infrastructure.combat.attacks;

import com.taller.patrones.domain.Attack;

public interface AttackFactory {
    Attack createAttack();
}
