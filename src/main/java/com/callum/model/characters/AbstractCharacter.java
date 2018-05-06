package com.callum.model.characters;

import com.callum.model.items.characterItems.armour.Chestplate;
import com.callum.model.items.characterItems.armour.Helmet;
import com.callum.model.items.characterItems.armour.Shield;
import com.callum.model.items.characterItems.weapons.Weapon;

/**
 * Created by callummarriage on 26/04/2018.
 */
public abstract class AbstractCharacter implements Character {

    protected String name;
    protected Weapon weapon;
    protected int health;
    protected boolean isDead;
    protected Helmet helmet;
    protected Chestplate chestplate;
    protected Shield shield;

    public AbstractCharacter(String name, Weapon weapon, int health) {
        this.weapon = weapon;
        this.name = name;
        this.health = health;
        this.isDead = false;
        helmet = null;
        chestplate = null;
        shield = null;
    }

    @Override
    public abstract boolean attack(Character opponent);

    @Override
    public abstract void speak(String command);

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(Integer health) {
        this.health = health ;
    }

    @Override
    public boolean getDead(){
        return this.isDead;
    }

    @Override
    public void kill(){
        this.isDead = true;
    }

    @Override
    public Weapon getWeapon(){
        return this.weapon;
    }

    public abstract boolean deflectAttack();

    @Override
    public Helmet getHelmet() {
        return helmet;
    }

    @Override
    public Chestplate getChestplate() {
        return chestplate;
    }

    @Override
    public Shield getShield() {
        return shield;
    }

}
