package com.taller.patrones.interfaces.rest;

import java.util.Map;

public class BattleAdapter {

    public BattleAdapterInput adapt(Map<String, Object> body){
        String fighter1Name = (String) body.getOrDefault("fighter1_name", "Héroe");
        int fighter1Hp = ((Number) body.getOrDefault("fighter1_hp", 150)).intValue();
        int fighter1Atk = ((Number) body.getOrDefault("fighter1_atk", 25)).intValue();
        String fighter2Name = (String) body.getOrDefault("fighter2_name", "Dragón");
        int fighter2Hp = ((Number) body.getOrDefault("fighter2_hp", 120)).intValue();
        int fighter2Atk = ((Number) body.getOrDefault("fighter2_atk", 30)).intValue();

        return new BattleAdapterInput(fighter1Name, fighter1Hp, fighter1Atk, fighter2Name, fighter2Hp, fighter2Atk);
    }

    public record BattleAdapterInput(String fighter1Name, int fighter1Hp,
                                     int fighter1Attack, String fighter2Name, int fighter2Hp,
                                     int fighter2Attack )
    {}
}
