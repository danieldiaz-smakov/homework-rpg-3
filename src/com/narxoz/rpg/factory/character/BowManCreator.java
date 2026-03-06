package com.narxoz.rpg.factory.character;

import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.character.classes.BowMan;

public class BowManCreator extends CharacterCreator {
    @Override
    protected Character factoryMethod(String name) {
        return new BowMan(name);
    }

    @Override
    public String getKey() {
        return "bowman";
    }
}
