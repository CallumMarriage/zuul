package com.callum.zuul.model.commands;

import com.callum.zuul.Application;

public interface Command{

    int getNumberArgument();

    String getSyntax();

    boolean act(Application g);

    void addArgument(String arg);

}