package com.callum.model.items.characterItems.weapons;

import com.callum.model.characters.Character;
import com.callum.model.items.characterItems.AbstractCharacterItem;

/**
 * Created by callummarriage on 26/04/2018.
 */
public abstract class AbstractWeapon extends AbstractCharacterItem implements Weapon{

    int maxDamage;
    int weaponHealth;

    public AbstractWeapon(String name, String description, int maxDamage){
        super(name, description);
        this.maxDamage = maxDamage;
        weaponHealth = 0;
    }

    @Override
    public Integer getDamage(){
        return maxDamage;
    }

    @Override
    public abstract Integer act(Character character);

    @Override
    public int getWeaponHealth() {
        return weaponHealth;
    }

    @Override
    public void setWeaponHealth(int weaponHealth) {
        this.weaponHealth = weaponHealth;
    }

}
