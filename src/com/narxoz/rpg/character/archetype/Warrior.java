package com.narxoz.rpg.character.archetype;

import com.narxoz.rpg.character.Character;

public abstract class Warrior extends Character {
    protected Warrior(String name) {
        super(name);
    }

    @Override
    public String getArchetypeName() {
        return "Warrior";
    }
}
