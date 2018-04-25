package com.callum.model.commands;

import com.callum.model.Game;

public interface Command{

    int getNumberArgument();

    String getSyntax();

    boolean act(Game g);

    void addArgument(String arg);

}