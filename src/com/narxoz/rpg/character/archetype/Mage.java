package com.narxoz.rpg.character.archetype;

import com.narxoz.rpg.character.Character;

public abstract class Mage extends Character {
    protected Mage(String name) {
        super(name);
    }

    @Override
    public String getArchetypeName() {
        return "Mage";
    }
}
