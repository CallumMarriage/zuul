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
        System.out.println(command);
    }

    public boolean unlock(Room room){
        for(Item item : items){
            if(item.getName().split("-")[0].equals(room.getName())){
                room.setLocked(false);
                item.setActive(false);
                items.remove(item);
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
                items.remove(item);
                return;
            }
        }
        System.out.println("You have no Health Packs");
    }

    public void setCharacterItem(Item item){
        System.out.println("You have picked up " + item.getBasicInfo());
        if(item instanceof Weapon){
            setWeapon((Weapon) item);
        } else if(item instanceof Armour){
            if (item instanceof Shield) {
                setShield((Shield) item);
            } else if (item instanceof Helmet) {
                setHelmet((Helmet) item);
            } else if (item instanceof Chestplate) {
                setChestplate((Chestplate) item);
            }
        } else {
            items.add(item);
        }
    }

    public void changeCharacterItem(String name){
        for(Item item: items){
            if(item instanceof Weapon && item.getName().equals(name)){
                setWeapon((Weapon) item);
            } else if(item instanceof Armour) {
                if (item instanceof Helmet && item.getName().equals(name)) {
                    setHelmet((Helmet) item);
                } else if (item instanceof Chestplate && item.getName().equals(name)){
                    setChestplate((Chestplate) item);
                } else if(item instanceof Shield && item.getName().equals(name)){
                    setShield((Shield) item);
                }
            }
        }
    }

    public void addCharItem(CharacterItem item){
        items.remove(item);
        assignedItems.add(item);
        System.out.println("You are now using the " + item.getName());

    }


    public void removeCharItem(CharacterItem item){
        assignedItems.remove(item);
        items.add(item);
    }

    public void setWeapon(Weapon weapon){
        if(this.weapon != null){
            removeCharItem(this.weapon);
        }
        addCharItem(weapon);
        this.weapon = weapon;

    }

    public void setHelmet(Helmet helmet){
        if(this.helmet != null){
            removeCharItem(this.helmet);
        }
        addCharItem(helmet);
        this.helmet = helmet;
    }

    public void setChestplate(Chestplate chestplate){
        if(this.chestplate != null){
            removeCharItem(this.chestplate);
        }
        addCharItem(chestplate);
        this.chestplate = chestplate;
    }

    public void setShield(Shield shield){
        if(this.shield != null){
            removeCharItem(this.chestplate);
        }
        addCharItem(shield);
        this.shield = shield;
    }

    @Override
    public boolean deflectAttack(){
        List<Armour> armour = new ArrayList<>();

        for(CharacterItem characterItem : getAssignedItems()){
            if(characterItem instanceof Armour){
                armour.add((Armour) characterItem);
            }
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
