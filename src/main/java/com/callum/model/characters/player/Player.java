package com.callum.model.characters.player;

import com.callum.model.characters.AbstractCharacter;
import com.callum.model.characters.Character;
import com.callum.model.items.characterItems.CharacterItem;
import com.callum.model.items.characterItems.armour.*;
import com.callum.model.items.factory.ItemFactory;
import com.callum.model.items.characterItems.weapons.Weapon;
import com.callum.model.items.Item;
import com.callum.model.rooms.Room;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by callummarriage on 26/04/2018.
 */
public class Player extends AbstractCharacter{

    private List<Item> items;
    private int score;

    private List<CharacterItem> assignedItems;

    public Player(Weapon weapon, String name, int health){
        super(name, weapon, health);
        items = new ArrayList<>();
        score = 0;
        assignedItems = new ArrayList<>();
        assignedItems.add(weapon);
    }

    public List<CharacterItem> getAssignedItems(){
        return this.assignedItems;
    }

    public List<Item> getItems(){
        return this.items;
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
                Weapon weapon = (Weapon) ItemFactory.createItem("sword","destiny","The Sword Of Destiney", "50" );
                Player player = new Player(weapon,"name", 0 );
                Integer increase = item.act(player);
                System.out.println("You have increased your health by " + increase);
                this.health += increase;
                item.setActive(false);
                return;
            }
        }
        System.out.println("You have no Health Packs");
    }

    public void setCharacterItem(Item item){
        System.out.println("You have picked up " + item.getBasicInfo());
        if(item instanceof Weapon){

            if(this.weapon != null) {
                items.add(this.weapon);
                assignedItems.remove(this.weapon);
            }
            this.weapon = (Weapon) item;
            assignedItems.add(this.weapon);

        } else if(item instanceof Armour){
            armour += ((Armour) item).getValue();
            if (item instanceof Shield) {
                if(shield != null){
                    assignedItems.remove(this.shield);
                    items.add(this.shield);
                }
                this.shield = (Shield) item;
                assignedItems.add(this.shield);
            } else if (item instanceof Helmet) {
                if(helmet != null){
                    assignedItems.remove(this.helmet);
                    items.add(this.helmet);
                }
                this.helmet = (Helmet) item;
            } else if (item instanceof Chestplate) {
                if(chestplate != null){
                    assignedItems.remove(this.chestplate);
                    items.add(this.chestplate);
                }
                this.chestplate = (Chestplate) item;
                assignedItems.add(this.chestplate);
            }
        } else {
            items.add(item);
        }
    }

    public void changeWeapons(String name){
        for(Item item: items){
            if(item instanceof Weapon && item.getName().equals(name)){
                if(this.weapon != null){
                    assignedItems.remove(this.weapon);
                    items.add(this.weapon);
                }
                items.remove(item);
                this.weapon = (Weapon) item;
                assignedItems.add(this.weapon);

                System.out.println("You are now using the " + item.getName());
            } else if(item instanceof Armour) {
                if (item instanceof Helmet && item.getName().equals(name)) {
                    if(this.helmet != null){
                        assignedItems.remove(this.helmet);
                        items.add(this.helmet);
                        health -= this.helmet.getValue();
                    }
                    items.remove(item);
                    this.helmet = (Helmet) item;
                    assignedItems.add(this.helmet);
                    health += this.helmet.getValue();
                    System.out.println("You are now wearing " + item.getName());
                } else if (item instanceof Chestplate && item.getName().equals(name)){
                    if(this.chestplate != null){
                        items.add(this.chestplate);
                        assignedItems.remove(this.chestplate);
                        health -= this.chestplate.getValue();

                    }
                    items.remove(item);
                    this.chestplate = (Chestplate) item;
                    assignedItems.add(this.chestplate);
                    health += this.chestplate.getValue();
                    System.out.println("You are now wearing " + item.getName());
                } else if(item instanceof Shield && item.getName().equals(name)){
                    if(this.shield != null){
                        assignedItems.remove(this.chestplate);
                        items.add(this.shield);
                        health -= this.shield.getValue();
                    }
                    items.remove(item);
                    this.shield = (Shield) item;
                    assignedItems.add(this.shield);
                    health += this.chestplate.getValue();
                    System.out.println("You now hold " + item.getName());
                }
            }
        }
    }

    @Override
    public boolean deflectAttack(){
        List<Armour> armour = new ArrayList<>();

        if(this.helmet != null){
            armour.add(this.helmet);
        }
        if(this.shield != null){
            armour.add(this.shield);
        }
        if(this.chestplate != null){
            armour.add(chestplate);
        }

        if(armour.size() > 0) {
            Random random = new SecureRandom();
            int rand = random.nextInt(armour.size() -1 + 1);

            return armour.get(rand).deflect();
        }
        return false;

    }

    public void updateScore(int score){
        this.score += score;
    }

    public int getScore(){
        return this.score;
    }
}
