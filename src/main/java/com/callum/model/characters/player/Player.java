package com.callum.model.characters.player;

import com.callum.model.characters.AbstractCharacter;
import com.callum.model.characters.Character;
import com.callum.model.items.Health;
import com.callum.model.items.Weapon;
import com.callum.model.items.Item;
import com.callum.model.rooms.Room;
import com.sun.tools.javac.jvm.Items;

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
    public boolean attack(Character opponent) {
        if(opponent != null){
            if(opponent.getHealth() >0) {
                int damage = weapon.act(opponent);
                System.out.println("You have attacked doing " + damage + " damage");
                return true;
            } else {
                System.out.println("No one to attack!");
                return false;
            }
        } else{
            return false;
        }
    }

    @Override
    public void speak(String command) {
        System.out.println("I am the player. I currently have " + weapon.getName() + "equiped.");
    }

    public void pickUp(Item item){
        System.out.println(item.giveDescription());
        items.add(item);
    }

    public boolean unlock(Room room){
        for(Item item : items){
            if(item.getName().split("-")[0].equals(room.getName())){
                room.setLocked(false);
                item.setActive(false);
                return true;
            }
        }
        return false;
    }

    public void heal(){
        for(Item item : items){
            if(item.getName().equals("health-pack")){
                Player player = new Player(new Weapon("Steve", "the sword of destiny", 0),"name", 0 );
                Integer increase = item.act(player);
                System.out.println("\n You have increased your health by " + increase);
                this.health += increase;
                item.setActive(false);
                return;
            }
        }
        System.out.println("You have no Health Packs");
    }
}
