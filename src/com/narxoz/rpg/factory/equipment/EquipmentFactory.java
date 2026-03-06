package com.narxoz.rpg.factory.equipment;

import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;

public interface EquipmentFactory {
    Weapon createWeapon();
    Armor createArmor();
    String getThemeName();
}
