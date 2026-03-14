package com.taller.patrones.application.command;

import com.taller.patrones.domain.Character;
import com.taller.patrones.application.observer.BattleEventBell;
import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;

public class AttackCommand implements  BattleCommand{
    private final Battle battle;
    private final String battleId;
    private final Character attacker;
    private final Character defender;
    private final Attack attack;
    private final int damage;

    private final int previousLastDamage;
    private final String previousLastDamageTarget;
    private final boolean battleWasFinished;

    private final BattleEventBell notifier;

    public AttackCommand(Battle battle, String battleId, Character attacker, Character defender,
                         Attack attack, int damage, BattleEventBell notifier) {
        this.battle = battle;
        this.battleId = battleId;
        this.attacker = attacker;
        this.defender = defender;
        this.attack = attack;
        this.damage = damage;
        this.notifier = notifier;
        this.previousLastDamage = battle.getLastDamage();
        this.previousLastDamageTarget = battle.getLastDamageTarget();
        this.battleWasFinished = battle.isFinished();
    }
    @Override
    public void execute() {
        defender.takeDamage(damage);
        String target = (defender == battle.getPlayer()) ?  "player" : "enemy";
        battle.setLastDamage(damage, target);
        battle.log(attacker.getName() +  " usa " + attack.getName() + " y hace " + damage + " de daño a " + defender.getName());

        if (notifier != null) {
            notifier.notifyDamageDealt(battleId, attacker, defender, damage, attack);
        }
        battle.switchTurn();
        if (notifier != null) {
            notifier.notifyTurnChanged(battleId, battle.getCurrentTurn());

        }
        if (!defender.isAlive()){
            battle.finish(attacker.getName());
            if (notifier != null) {
                notifier.notifyBattleEnd(battleId, attacker.getName());
                }
            }

        }

    @Override
    public void undo() {
        defender.heal(damage);
        battle.switchTurn();
        battle.setLastDamage(previousLastDamage, previousLastDamageTarget);

        if(battleWasFinished){
            battle.unfinish();
        }
        battle.removeLastLogEntry();
    }
}
