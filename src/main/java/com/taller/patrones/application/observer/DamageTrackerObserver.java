package com.taller.patrones.application.observer;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;

public class DamageTrackerObserver implements BattleDamageListener {

    @Override
    public void onDamageApplied(Battle battle, Character attacker, Character defender, int damage, Attack attack) {
        String target = defender == battle.getPlayer() ? "player" : "enemy";
        battle.setLastDamage(damage, target);

    }
}
