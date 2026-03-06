package com.narxoz.rpg.character.classes;

import com.narxoz.rpg.character.archetype.Mage;

public class Necromancer extends Mage {
    public Necromancer(String name) {
        super(name);
        health = 80;
        mana = 130;
        strength = 10;
        intelligence = 100;
        dexterity = 20;
    }

    @Override
    public String getClassName() {
        return "Necromancer";
    }

    @Override
    public String useSpecialAbility() {
        return "Raise Dead: summons undead minions.";
    }
}
