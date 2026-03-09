package com.taller.patrones.infrastructure.combat.attacks;

public class AttackSelector {
    public AttackFactory getFactory(String name){
        String n = name != null ? name.toUpperCase() : "";
        return switch(n) {
            case "TACKLE" -> new TackleAttack();
            case "SLASH" -> new SlashAttack();
            case "FIREBALL" -> new FireballAttack();
            case "ICE_BEAM" -> new IceBeamAttack();
            case "POISON_STING" ->new PoisonStingAttack();
            case "THUNDER" -> new ThunderAttack();
            case "METEORO" -> new MeteoroAttack();
            default -> new GolpeAttack();
        };
    }
}
