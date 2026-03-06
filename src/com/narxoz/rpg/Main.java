package com.narxoz.rpg;

import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.adapter.HeroCombatantAdapter;
import com.narxoz.rpg.battle.BattleEngine;
import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.battle.EncounterResult;
import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.character.PaladinCreator;
import com.narxoz.rpg.factory.character.NecromancerCreator;
import com.narxoz.rpg.factory.equipment.MedievalEquipmentFactory;
import com.narxoz.rpg.factory.equipment.MagicEquipmentFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Battle Engine Demo ===\n");

        // Герои из HW1: создаём через Factory (CharacterCreator + EquipmentFactory)
        PaladinCreator paladinCreator = new PaladinCreator();
        NecromancerCreator necromancerCreator = new NecromancerCreator();
        MedievalEquipmentFactory medieval = new MedievalEquipmentFactory();
        MagicEquipmentFactory magic = new MagicEquipmentFactory();

        Character paladin = paladinCreator.create("Lares", medieval);
        Character necromancer = necromancerCreator.create("Ksardas", magic);

        // Враги из HW2
        Goblin goblin = new Goblin("Goblin");

        // Оборачиваем в адаптеры (Adapter pattern)
        List<Combatant> heroes = new ArrayList<>();
        heroes.add(new HeroCombatantAdapter(paladin));
        heroes.add(new HeroCombatantAdapter(necromancer));

        List<Combatant> enemies = new ArrayList<>();
        enemies.add(new EnemyCombatantAdapter(goblin));

        // Демонстрация Singleton
        BattleEngine engineA = BattleEngine.getInstance();
        BattleEngine engineB = BattleEngine.getInstance();
        System.out.println("Same instance? " + (engineA == engineB));
        System.out.println();

        // Запуск боя
        engineA.setRandomSeed(42L);
        EncounterResult result = engineA.runEncounter(heroes, enemies);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        for (String line : result.getBattleLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
