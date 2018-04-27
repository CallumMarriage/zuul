package com.callum.model.characters.player;

import com.callum.model.Game;
import com.callum.model.characters.AbstractCharacter;
import com.callum.model.characters.Character;
import com.callum.model.characters.weapons.Weapon;
import com.callum.model.items.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class Player extends AbstractCharacter{

    private List<Item> items;

    public Player(Weapon weapon, String name, int health){
        super(name, weapon, health);
        items = new ArrayList<>();
    }

    @Override
    public void attack(Character opponent) {
        if(opponent.getHealth() >0) {
            int damage = weapon.dealDamage(opponent);
            System.out.println("You have attacked doing " + damage + " damage");
        } else {
            System.out.println("No one to attack!");
        }
    }

    @Override
    public void speak(String command) {
        System.out.println("I am the player. I currently have " + weapon.getName() + "equiped.");
    }

    public void pickUpKey(Item item){
        items.add(item);
    }
}
