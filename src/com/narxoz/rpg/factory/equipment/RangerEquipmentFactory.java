package com.narxoz.rpg.factory.equipment;

import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;
import com.narxoz.rpg.equipment.themes.ranger.Bow;
import com.narxoz.rpg.equipment.themes.ranger.LeatherArmor;

public class RangerEquipmentFactory implements EquipmentFactory {
    @Override
    public Weapon createWeapon() {
        return new Bow();
    }

    @Override
    public Armor createArmor() {
        return new LeatherArmor();
    }

    @Override
    public String getThemeName() {
        return "Ranger";
    }
}
