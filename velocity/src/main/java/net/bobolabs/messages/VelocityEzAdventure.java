package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.ProxyServer;
import org.jetbrains.annotations.NotNull;

public class VelocityEzAdventure extends AbstractEzAdventure<CommandSource, VelocityEzAdventurePhase1, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3> {

    // Boh?
    private final EzAdventureOptions options;
    private ProxyServer server;

    public VelocityEzAdventure(@NotNull ProxyServer server, @NotNull EzAdventureOptions options) {
        this.options = options;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase1 sync() {
        return new VelocityEzAdventurePhase1(false);
    }

    @Override
    public @NotNull VelocityEzAdventurePhase1 async() {
        return new VelocityEzAdventurePhase1(true);
    }

}
