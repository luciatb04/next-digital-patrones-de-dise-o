package com.taller.patrones.application.observer;

import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;

import java.util.ArrayList;
import java.util.List;

public class BattleEventBell {
    private final List<BattleDamageListener> listeners = new ArrayList<>();

    public void addListener(BattleDamageListener listener){
        listeners.add(listener);
    }

    public void notifyDamageApplied(Battle battle, Character attacker, Character defender, int damage, Attack attack){
        listeners.forEach(l->l.onDamageApplied(battle, attacker, defender, damage, attack));
    }
    public void notifyDamageDealt(String battleId, Character attacker, Character defender, int damage, Attack attack) {
        listeners.forEach(l -> l.onDamageDealt(battleId, attacker, defender, damage, attack));
    }

    public void notifyTurnChanged(String battleId, String currentTurn) {
        listeners.forEach(l -> l.onTurnChanged(battleId, currentTurn));
    }

    public void notifyBattleEnd(String battleId, String winnerName) {
        listeners.forEach(l -> l.onBattleEnd(battleId, winnerName));
    }
}
