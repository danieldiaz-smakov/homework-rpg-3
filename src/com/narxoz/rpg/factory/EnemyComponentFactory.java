package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

/** Abstract Factory для создания тематических компонентов врагов. */
public interface EnemyComponentFactory {

    List<Ability> createAbilities();
    LootTable createLootTable();
    String createAIBehavior();
}
