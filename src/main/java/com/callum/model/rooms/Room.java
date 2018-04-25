package com.callum.model.rooms;
import com.callum.model.Directions;

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

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court 
     * yard".
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
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
    public void joinRooms(String direction, Room otherRoom){

        for(String exit : exits.keySet()){
            if(direction.equals(exit)){
                System.out.println("Warning!!!!! " + otherRoom.description + " Was not created!! (Cant have two rooms in one direction)");
                return;
            }
        }

        this.setExit(direction, otherRoom);
        otherRoom.setExit(Directions.opposite(direction), this);

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
    public String getLongDescription()
    {
        return "You are in " + description + ".\n" + getExitString();
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
}

