package com.narxoz.rpg.factory.equipment;

import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;
import com.narxoz.rpg.equipment.themes.magic.Robes;
import com.narxoz.rpg.equipment.themes.magic.Staff;

public class MagicEquipmentFactory implements EquipmentFactory {
    @Override
    public Weapon createWeapon() {
        return new Staff();
    }

    @Override
    public Armor createArmor() {
        return new Robes();
    }

    @Override
    public String getThemeName() {
        return "Magic";
    }
}
