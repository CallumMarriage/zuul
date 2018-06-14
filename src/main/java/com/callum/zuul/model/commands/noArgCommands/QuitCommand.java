package com.callum.zuul.model.commands.noArgCommands;

import com.callum.zuul.Application;

/**
 * Created by callummarriage on 24/04/2018.
 */
public class QuitCommand extends NoArgCommand {

    public String getSyntax() {
        return "quit";
    }

    public boolean act(Application g) {

        System.out.println("Thank you for playing!");
        System.exit(200);
        return true;
    }

}
