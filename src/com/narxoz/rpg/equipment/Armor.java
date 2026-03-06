package com.narxoz.rpg.equipment;

public abstract class Armor {
    protected final String name;
    protected final int defense;
    protected final ArmorType armorType;

    protected Armor(String name, int defense, ArmorType armorType) {
        this.name = name;
        this.defense = defense;
        this.armorType = armorType;
    }

    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public String getArmorInfo() {
        return name + " [" + armorType + "], DEF=" + defense;
    }
}
