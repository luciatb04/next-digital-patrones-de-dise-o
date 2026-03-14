package com.taller.patrones.infrastructure.combat;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Character;
import com.taller.patrones.infrastructure.combat.attacks.AttackFactory;
import com.taller.patrones.infrastructure.combat.attacks.AttackSelector;
import com.taller.patrones.infrastructure.combat.damage.DamageSelector;
import com.taller.patrones.infrastructure.combat.damage.DamageStrategy;

/**
 * Motor de combate. Calcula daño y crea ataques.
 * <p>
 * Nota: Esta clase crece cada vez que añadimos un ataque nuevo o un tipo de daño distinto.
 */
public class CombatEngine {
    private final AttackSelector attackSelector = new AttackSelector();

    public Attack createAttack(String name){
        AttackFactory factory = attackSelector.getFactory(name);
        return factory.createAttack();
    }

    public int calculateDamage(Character attacker, Character defender, Attack attack) {
        DamageStrategy strategy = DamageSelector.getStrategy(attack.getType());

        return strategy.calculateDamage(attacker, defender, attack);
    }

}
