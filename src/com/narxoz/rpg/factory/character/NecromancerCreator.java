package com.narxoz.rpg.factory.character;

import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.character.classes.Necromancer;

public class NecromancerCreator extends CharacterCreator {
    @Override
    protected Character factoryMethod(String name) {
        return new Necromancer(name);
    }

    @Override
    public String getKey() {
        return "necromancer";
    }
}
