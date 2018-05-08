package com.callum.zuul.model.items.characterItems.armour;

import com.callum.zuul.model.characters.Character;
import com.callum.zuul.model.items.characterItems.AbstractCharacterItem;

import java.util.Random;

/**
 * Created by callummarriage on 02/05/2018.
 */
public abstract class AbstractArmour extends AbstractCharacterItem implements Armour {

    public Integer value;

    public AbstractArmour(String name, String description, Integer value) {
        super(name, description);
        this.value = value;
    }

    @Override
    public Integer act(Character character) {
        return null;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public abstract boolean deflect();

    public boolean decideDeflection(Random random){
        if(random.nextBoolean()){
            System.out.println("And was deflected!");
            return true;
        } else {
            System.out.println("And your " + name + " has failed you!");
            return false;
        }
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }
}
