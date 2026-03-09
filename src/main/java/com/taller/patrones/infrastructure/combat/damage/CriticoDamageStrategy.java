package com.taller.patrones.infrastructure.combat.damage;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;

/*
Además, te piden un nuevo tipo: "CRÍTICO", con fórmula daño * 1.5 y 20% de probabilidad.
 */
public class CriticoDamageStrategy implements DamageStrategy{
    @Override
    public int calculateDamage(Character attacker, Character defender, Attack attack) {
        int raw = attacker.getAttack() * attack.getBasePower() / 100;
        if (Math.random() <= .2){
            raw = (int) (raw*1.5);
        }
        return Math.max(1, raw - defender.getDefense());

    }
}
