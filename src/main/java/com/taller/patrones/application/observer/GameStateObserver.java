package com.taller.patrones.application.observer;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;

public class GameStateObserver implements BattleDamageListener{
    @Override
    public void onDamageApplied(Battle battle, Character attacker, Character defender, int damage, Attack attack) {
        battle.switchTurn();
        if(!defender.isAlive()){
            battle.finish(attacker.getName());
        }
    }
}
