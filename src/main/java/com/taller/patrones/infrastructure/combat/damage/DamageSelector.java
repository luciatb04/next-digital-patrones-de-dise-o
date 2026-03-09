package com.taller.patrones.infrastructure.combat.damage;

import com.taller.patrones.domain.Attack;

public class DamageSelector {
    public static DamageStrategy getStrategy(Attack.AttackType type) {
        return switch (type) {
            case NORMAL -> new NormalDamageStrategy();
            case SPECIAL -> new SpecialDamageStrategy();
            case STATUS -> new StatusDamageStrategy();
            case CRITICO -> new CriticoDamageStrategy();
        };
    }
}
