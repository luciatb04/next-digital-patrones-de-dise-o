package com.taller.patrones.application.observer;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;

public class BattleLogObserver implements BattleDamageListener{
    @Override
    public void onDamageApplied(Battle battle, Character attacker, Character defender, int damage, Attack attack) {
        battle.log(attacker.getName() + " usa " + attack.getName() + " y hace " + damage + " de daño a " + defender.getName());
    }

    @Override
    public void onDamageDealt(String battleId, Character attacker, Character defender, int damage, Attack attack) {

    }

    @Override
    public void onTurnChanged(String battleId, String currentTurn) {

    }

    @Override
    public void onBattleEnd(String battleId, String winnerName) {

    }
}
