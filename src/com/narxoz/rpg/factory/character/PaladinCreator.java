package com.narxoz.rpg.factory.character;

import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.character.classes.Paladin;

public class PaladinCreator extends CharacterCreator {
    @Override
    protected Character factoryMethod(String name) {
        return new Paladin(name);
    }

    @Override
    public String getKey() {
        return "paladin";
    }
}
