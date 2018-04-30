package com.callum.model.rooms;
import com.callum.model.Directions;
import com.callum.model.characters.Character;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;


/*
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

public abstract class Room {
    protected String description;
    protected HashMap<String, Room> exits;        // stores exits of this room.
    protected Enemy enemy;
    protected List<Item> items;
    protected String name;
    protected boolean isLocked;
    protected boolean isBossRoom;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court 
     * yard".
     */
    public Room(String name, String description,boolean isLocked, boolean isBossRoom) {
        this.name = name;
        this.description = description;
        this.isLocked = isLocked;
        exits = new HashMap<String, Room>();
        this.items = new ArrayList<>();
        this.isBossRoom = isBossRoom;
        this.enemy = null;
    }

    public boolean getIsBossRoom(){
        return this.isBossRoom;
    }


    public boolean getLocked(){
        return this.isLocked;
    }

    public void setLocked(Boolean newLocked){
        this.isLocked = newLocked;

    }
    /**
     * Define an exit from this room.
     */
    public void setExit(String direction, Room neighbor) {
        if (Directions.isDirection(direction)) {
            exits.put(direction, neighbor);
        }
    }

    /**
     * Connect two rooms.
     */
    public boolean joinRooms(String direction, Room otherRoom){

        for(String exit : exits.keySet()){
            if(direction.equals(exit)){
                System.out.println(direction +"-"+ otherRoom.getShortDescription() + "-FAILED");
                return false;
            }
        }
        this.setExit(direction, otherRoom);
        otherRoom.setExit(Directions.opposite(direction), this);
        return true;
    }

    public boolean joinRandomRooms(Room otherRoom){
        List<String> directions = new ArrayList<>();
        directions.add("south");
        directions.add("west");
        directions.add("east");
        directions.add("north");

        for(String direction: directions) {
            boolean isValid = true;
            for (String exit : exits.keySet()) {
                if (direction.equals(exit)) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                joinRooms(direction, otherRoom);
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a String representation of the room
     */
    public String toString() {
	return getShortDescription();
    }

    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of this room, in the form:
     *     You are in the kitchen.
     *     Exits: north west
     */
    public String getLongDescription() {

        StringBuilder sb = new StringBuilder();
        sb.append("You are in ");
        sb.append(description);
        sb.append(".\n");
        sb.append(getExitString());

        if(items.size() > 0) {
            for (Item item : this.items) {
                if (item.isActive()) {
                    sb.append(item.getLongDescription());
                } else {
                    sb.append("\nYou have already pickup up the ");
                    sb.append(item.getName());
                }
            }
        }
        if(getEnemy() == null || getEnemy().getDead()){
            sb.append("\nIt is empty, you may move on");
        }

        return sb.toString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    public String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String d : keys)
            returnString += " " + d;
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public abstract Room getExit(String direction);

    public void setEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        if(enemy != null) {
            return enemy;
        } else{
            return null;
        }
    }

    public void setItem(Item item){
        this.items.add(item);
    }

    public List<Item> getItems(){
        List<Item> activeItems = new ArrayList<>();
        for(Item item : this.items){
            if(item.isActive()){
                activeItems.add(item);
            }
        }
        return activeItems;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

