package com.narxoz.rpg.factory.character;

import com.narxoz.rpg.character.Character;
import com.narxoz.rpg.factory.equipment.EquipmentFactory;

public abstract class CharacterCreator {
    public Character create(String name, EquipmentFactory equipmentFactory) {
        Character character = factoryMethod(name);
        var weapon = equipmentFactory.createWeapon();
        var armor = equipmentFactory.createArmor();
        character.equip(weapon, armor);
        return character;
    }

    protected abstract Character factoryMethod(String name);
    public abstract String getKey();
}
