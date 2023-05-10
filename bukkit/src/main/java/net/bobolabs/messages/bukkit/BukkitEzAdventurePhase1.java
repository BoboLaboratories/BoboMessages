package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventurePhase1;
import org.bukkit.command.CommandSender;

public class BukkitEzAdventurePhase1 extends AbstractEzAdventurePhase1<CommandSender, BukkitEzAdventurePhase2, BukkitEzAdventurePhase3> {

    public BukkitEzAdventurePhase1(boolean async) {
        super(async);
    }

}
