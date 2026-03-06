package com.narxoz.rpg.equipment;

public abstract class Weapon {
    protected final String name;
    protected final int damage;
    protected final WeaponType weaponType;

    protected Weapon(String name, int damage, WeaponType weaponType) {
        this.name = name;
        this.damage = damage;
        this.weaponType = weaponType;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public String getWeaponInfo() {
        return name + " [" + weaponType + "], DMG=" + damage;
    }
}
