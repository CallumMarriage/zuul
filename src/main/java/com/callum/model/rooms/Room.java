package com.callum.model.rooms;

import com.callum.model.Directions;
import com.callum.model.characters.enemies.Enemy;
import com.callum.model.items.Item;

import java.util.*;

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
    protected boolean isStartingRoom;

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
        this.isStartingRoom = false;
    }

    public boolean getIsStartingRoom(){
        return this.isStartingRoom;
    }

    public void setIsStartingRoom(boolean setStartingRoom){
        this.isStartingRoom = true;
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
                getExit(exit).setExit("north", otherRoom);
                return true;
            }
        }
        this.setExit(direction, otherRoom);
        try {
            otherRoom.setExit(Directions.opposite(direction), this);
        } catch(NullPointerException e){
            System.out.println(otherRoom.description);
            System.out.println(direction);
            e.printStackTrace();
        }
        return true;
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
                if(item != null) {
                    if (item.isActive()) {
                        sb.append(item.getLongDescription());
                    } else {
                        sb.append("\nYou have already picked up the ");
                        sb.append(item.getName());
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    public String getExitString() {
        StringBuilder returnString = new StringBuilder();
        returnString.append("Exits:");
        Set<String> keys = exits.keySet();
        for(String d : keys) {
            returnString.append(" ");
            returnString.append(d);
        }
        return returnString.toString();
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

