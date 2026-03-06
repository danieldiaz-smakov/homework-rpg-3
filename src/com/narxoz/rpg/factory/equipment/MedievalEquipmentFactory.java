package com.narxoz.rpg.factory.equipment;

import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;
import com.narxoz.rpg.equipment.themes.medieval.PlateArmor;
import com.narxoz.rpg.equipment.themes.medieval.Sword;

public class MedievalEquipmentFactory implements EquipmentFactory {
    @Override
    public Weapon createWeapon() {
        return new Sword();
    }

    @Override
    public Armor createArmor() {
        return new PlateArmor();
    }

    @Override
    public String getThemeName() {
        return "Medieval";
    }
}
