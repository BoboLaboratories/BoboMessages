package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class VelocityEzAdventurePhase1
        extends AbstractEzAdventurePhase1<CommandSource, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3>
        implements EzAdventurePhase1<CommandSource, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3> {

    public VelocityEzAdventurePhase1(boolean async) {
        super(async);
    }
}
