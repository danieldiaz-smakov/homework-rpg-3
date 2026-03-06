package com.narxoz.rpg.character;

import com.narxoz.rpg.equipment.Armor;
import com.narxoz.rpg.equipment.Weapon;

public abstract class Character {
    protected String name;

    protected int health;
    protected int mana;
    protected int strength;
    protected int intelligence;
    protected int dexterity;

    protected Weapon weapon;
    protected Armor armor;

    protected Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Для боя (HW3): текущее здоровье. */
    public int getHealth() {
        return health;
    }

    /** Для боя (HW3): получить урон, здоровье не ниже 0. */
    public void receiveDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    /** Для боя (HW3): жив ли персонаж. */
    public boolean isAlive() {
        return health > 0;
    }

    /** Для боя (HW3): сила атаки (урон оружия). */
    public int getPower() {
        return getTotalDamage();
    }

    public int getTotalDamage() {
        return weapon == null ? 0 : weapon.getDamage();
    }

    public int getTotalDefense() {
        return armor == null ? 0 : armor.getDefense();
    }

    public Weapon getWeapon() { return weapon; }

    public Armor getArmor() { return armor; }

    public void equip(Weapon weapon, Armor armor) {
        this.weapon = weapon;
        this.armor = armor;
    }

    public String getStats() {
        return ""
                + "Name: " + name + "\n"
                + "Class: " + getClassName() + " (" + getArchetypeName() + ")\n"
                + "HP: " + health + ", Mana: " + mana + "\n"
                + "STR: " + strength + ", INT: " + intelligence + ", DEX: " + dexterity + "\n"
                + "DMG: " + getTotalDamage() + ", DEF: " + getTotalDefense();
    }

    public abstract String getClassName();
    public abstract String getArchetypeName();
    public abstract String useSpecialAbility();
}

