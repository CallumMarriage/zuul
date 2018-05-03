package com.callum.model.items.characterItems.armour;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by callummarriage on 02/05/2018.
 */
public class Chestplate extends AbstractArmour {
    public Chestplate(String name, String description, Integer value) {
        super(name, description, value);
    }

    @Override
    public boolean deflect() {
        Random random = new SecureRandom();
        Integer deflection = random.nextInt((20)+1);

        if(deflection > 12) {
            return true;
        }

        return false;
    }
}
