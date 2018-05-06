package com.callum.model.commands.noArgCommands.attackCommands;

import com.callum.Game;

/**
 * Created by callummarriage on 06/05/2018.
 */
public class SwordAttackCommand extends AttackCommand {
    @Override
    public boolean act(Game g){
        return attack(g, "sword");
    }
}
