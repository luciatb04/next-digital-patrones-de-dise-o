package com.taller.patrones.application.observer;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;

public interface BattleDamageListener {
    void onDamageApplied(Battle battle, Character attacker, Character defender, int damage, Attack attack);
}
