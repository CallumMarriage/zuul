package com.callum.model.items.characterItems.weapons;

import com.callum.model.characters.Character;
import com.callum.model.items.characterItems.AbstractCharacterItem;

import java.security.SecureRandom;

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
    public Integer act(Character character){
        SecureRandom rand = new SecureRandom();
        int i = rand.nextInt(maxDamage) + 1;
        if(character.deflectAttack()){
            return 0;
        } else {
            int temp = 0;
            if (character.getChestplate() != null) {
                if (character.getChestplate().getValue() > 0) {
                    if (character.getChestplate().getValue() >= i) {
                        character.getChestplate().setValue(character.getChestplate().getValue() - i);
                    } else {
                        temp = i - character.getChestplate().getValue();
                        character.getChestplate().setValue(0);
                    }
                }
            }else if (character.getHelmet() != null) {
                if (character.getHelmet().getValue() > 0) {
                    if (character.getHelmet().getValue() >= i) {
                        character.getHelmet().setValue(character.getHelmet().getValue() - i);
                    } else {
                        temp = i - character.getHelmet().getValue();
                        character.getHelmet().setValue(0);
                    }
                }
            } else if(character.getShield() != null) {
                if (character.getShield().getValue() > 0) {
                    if (character.getShield().getValue() >= i) {
                        character.getShield().setValue(character.getShield().getValue() - i);
                    } else {
                        temp = i - character.getShield().getValue();
                        character.getShield().setValue(0);
                    }
                }
            } else {
                temp = i;
            }
            character.setHealth(character.getHealth() - temp);
        }
        return i;
    }

    @Override
    public Integer getDamage(){
        return maxDamage;
    }

    @Override
    public int getWeaponHealth() {
        return weaponHealth;
    }

    @Override
    public void setWeaponHealth(int weaponHealth) {
        this.weaponHealth = weaponHealth;
    }

}
