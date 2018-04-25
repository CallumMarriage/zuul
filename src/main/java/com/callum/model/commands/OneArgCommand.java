package com.callum.model.commands;

import com.callum.model.Game;

/**
 * Created by callummarriage on 25/04/2018.
 */
public class OneArgCommand implements Command {

    protected  String direction;

    @Override
    public int getNumberArgument() {
        return 1;
    }

    @Override
    public String getSyntax() {
        return null;
    }

    @Override
    public boolean act(Game g) {
        return false;
    }

    @Override
    public void addArgument(String arg) {
        if(arg.split(" ").length == 1){
            this.direction = arg;
        } else {
            System.out.println("You have given an invalid direction");
        }
    }
}
