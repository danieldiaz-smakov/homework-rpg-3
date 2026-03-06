package com.narxoz.rpg.character.classes;

import com.narxoz.rpg.character.archetype.Ranger;

public class BowMan extends Ranger {
    public BowMan(String name) {
        super(name);
        health = 95;
        mana = 35;
        strength = 35;
        intelligence = 25;
        dexterity = 90;
    }

    @Override
    public String getClassName() {
        return "BowMan";
    }

    @Override
    public String useSpecialAbility() {
        return "Piercing Arrow: ignores part of enemy defense.";
    }
}
