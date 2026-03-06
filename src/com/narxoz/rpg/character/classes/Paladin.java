package com.narxoz.rpg.character.classes;

import com.narxoz.rpg.character.archetype.Warrior;

public class Paladin extends Warrior {
    public Paladin(String name) {
        super(name);
        health = 140;
        mana = 40;
        strength = 80;
        intelligence = 30;
        dexterity = 25;
    }

    @Override
    public String getClassName() {
        return "Paladin";
    }

    @Override
    public String useSpecialAbility() {
        return "Holy Shield: temporarily increases defense and blocks damage.";
    }
}
