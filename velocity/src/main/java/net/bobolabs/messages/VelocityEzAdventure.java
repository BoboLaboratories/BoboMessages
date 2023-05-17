package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.ConsoleCommandSource;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public final class VelocityEzAdventure extends AbstractEzAdventure<CommandSource, VelocityEzAdventurePhase1, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3> {
    private final ProxyServer server;

    public VelocityEzAdventure(@NotNull ProxyServer server, @NotNull EzAdventureOptions options) {
        super(options);
        this.server = server;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase1 sync() {
        return new VelocityEzAdventurePhase1(server, this, false);
    }

    @Override
    public @NotNull VelocityEzAdventurePhase1 async() {
        return new VelocityEzAdventurePhase1(server, this, true);
    }

    @Override
    public @NotNull Locale getLocale(@NotNull CommandSource audience) {
        return audience instanceof Player player ?
                player.getPlayerSettings().getLocale() :
                getDefaultLocale();
    }

}
