package com.taller.patrones.application;

import com.taller.patrones.application.command.AttackCommand;
import com.taller.patrones.application.command.BattleCommand;
import com.taller.patrones.domain.Attack;
import com.taller.patrones.domain.Battle;
import com.taller.patrones.domain.Character;
import com.taller.patrones.domain.CharacterBuilder;
import com.taller.patrones.infrastructure.combat.CombatEngine;
import com.taller.patrones.infrastructure.persistence.BattleRepository;

import com.taller.patrones.application.observer.BattleEventBell;
import com.taller.patrones.application.observer.DamageTrackerObserver;
import com.taller.patrones.application.observer.BattleLogObserver;
import com.taller.patrones.application.observer.GameStateObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Caso de uso: gestionar batallas.
 * <p>
 * Nota: Crea sus propias dependencias con new. Cada vez que necesitamos
 * un CombatEngine o BattleRepository, hacemos new aquí.
 */


public class BattleService {

    private final CombatEngine combatEngine = new CombatEngine();
    private final BattleRepository battleRepository =  BattleRepository.getInstance();

    private final BattleEventBell battleEventBell;

    public static final List<String> PLAYER_ATTACKS = List.of("TACKLE", "SLASH", "FIREBALL", "ICE_BEAM", "POISON_STING", "THUNDER", "METEORO");
    public static final List<String> ENEMY_ATTACKS = List.of("TACKLE", "SLASH", "FIREBALL");

    private final List<BattleCommand> commandHistory = new ArrayList<>();

    public BattleService() {
        this.battleEventBell = new BattleEventBell();
        this.battleEventBell.addListener(new DamageTrackerObserver());
        this.battleEventBell.addListener(new BattleLogObserver());
        this.battleEventBell.addListener(new GameStateObserver());
    }

    public BattleStartResult startBattle(String playerName, String enemyName) {

        Character player = new CharacterBuilder()
                .name(playerName != null ? playerName : "Héroe")
                .maxHp(150)
                .attack(25)
                .defense(15)
                .speed(20)
                .build();

        Character enemy = new CharacterBuilder()
                .name(enemyName != null ? playerName : "Dragon")
                .maxHp(120)
                .attack(30)
                .defense(10)
                .speed(15)
                .build();

        Battle battle = new Battle(player, enemy);
        String battleId = UUID.randomUUID().toString();
        battleRepository.save(battleId, battle);

        return new BattleStartResult(battleId, battle);
    }

    public Battle getBattle(String battleId) {
        return battleRepository.findById(battleId);
    }

    public void executePlayerAttack(String battleId, String attackName) {
        Battle battle = battleRepository.findById(battleId);
        if (battle == null || battle.isFinished() || !battle.isPlayerTurn()) return;

        Attack attack = combatEngine.createAttack(attackName);
        int damage = combatEngine.calculateDamage(battle.getPlayer(), battle.getEnemy(), attack);
        applyDamage(battleId,battle, battle.getPlayer(), battle.getEnemy(), damage, attack);
    }

    public void executeEnemyAttack(String battleId, String attackName) {
        Battle battle = battleRepository.findById(battleId);
        if (battle == null || battle.isFinished() || battle.isPlayerTurn()) return;

        Attack attack = combatEngine.createAttack(attackName != null ? attackName : "TACKLE");
        int damage = combatEngine.calculateDamage(battle.getEnemy(), battle.getPlayer(), attack);
        applyDamage(battleId,battle, battle.getEnemy(), battle.getPlayer(), damage, attack);
    }

    private void applyDamage(String battleId, Battle battle, Character attacker, Character defender, int damage, Attack attack) {
        BattleCommand command = new AttackCommand(  battle, battleId, attacker, defender, attack, damage, battleEventBell);
        command.execute();
        commandHistory.add(command); // Nota: usa .push(command) si al final dejaste el Stack en vez de la List
    }
    public BattleStartResult startBattleFromExternal(String fighter1Name, int fighter1Hp, int fighter1Atk,
                                                     String fighter2Name, int fighter2Hp, int fighter2Atk) {
        Character player = new CharacterBuilder()
                .name(fighter1Name)
                .maxHp(fighter1Hp)
                .attack(fighter1Atk)
                .defense(10)
                .speed(10)
                .build();
        Character enemy = new CharacterBuilder()
                .name(fighter2Name)
                .maxHp(fighter2Hp)
                .attack(fighter2Atk)
                .defense(10)
                .speed(10)
                .build();
        Battle battle = new Battle(player, enemy);
        String battleId = UUID.randomUUID().toString();
        battleRepository.save(battleId, battle);
        return new BattleStartResult(battleId, battle);
    }

    public record BattleStartResult(String battleId, Battle battle) {}
}
