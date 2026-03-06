package com.narxoz.rpg.character.archetype;

import com.narxoz.rpg.character.Character;

public abstract class Ranger extends Character {
    protected Ranger(String name) {
        super(name);
    }

    @Override
    public String getArchetypeName() {
        return "Ranger";
    }
}
