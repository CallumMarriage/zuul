package com.callum.zuul.model.items.characterItems;

import com.callum.zuul.model.characters.Character;
import com.callum.zuul.model.items.AbstractItem;
import com.callum.zuul.model.items.characterItems.armour.Armour;
import com.callum.zuul.model.items.characterItems.weapons.Weapon;

/**
 * Created by callummarriage on 02/05/2018.
 */
public abstract class AbstractCharacterItem extends AbstractItem implements CharacterItem{


    public AbstractCharacterItem(String name, String description) {
        super(name, description);
    }

    @Override
    public abstract Integer act(Character character);

    @Override
    public String getCharacterItemsAndValues(){
        if(this instanceof Armour){
            Armour armour = (Armour) this;
            return this.getName() + " : Armour : "+ armour.getValue();
        } else if(this instanceof Weapon) {
            Weapon weapon = (Weapon) this;
            return this.getName() + " : Damage : " + weapon.getDamage() + " | Health : " + weapon.getWeaponHealth();
        }
        return null;
    }
}
