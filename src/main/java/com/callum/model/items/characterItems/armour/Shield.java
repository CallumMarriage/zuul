package com.callum.model.items.characterItems.armour;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by callummarriage on 02/05/2018.
 */
public class Shield extends AbstractArmour {
    public Shield(String name, String description, Integer value) {
        super(name, description, value);
    }

    @Override
    public boolean deflect() {
        Random random = new SecureRandom();
        Integer deflection = random.nextInt((value)+1);

        if(deflection > (int)(value*(55.0f/100.0f))){
            System.out.println("The enemy has struck your Shield...");
            if(random.nextBoolean()){
                System.out.println("And was deflected!");
                return true;
            } else {
                System.out.println("And your " + name + " has failed you!");
                return false;
            }
        }

        return false;
    }
}
