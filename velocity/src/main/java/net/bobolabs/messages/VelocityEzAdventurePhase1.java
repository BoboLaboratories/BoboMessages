package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

public final class VelocityEzAdventurePhase1
        extends AbstractEzAdventurePhase1<CommandSource, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3>
        implements EzAdventurePhase1<CommandSource, VelocityEzAdventurePhase2, VelocityEzAdventurePhase3> {
    private final VelocityEzAdventure ezAdventure;
    private final ProxyServer server;

    public VelocityEzAdventurePhase1(@NotNull ProxyServer server, @NotNull VelocityEzAdventure ezAdventure, boolean async) {
        super(ezAdventure, async);
        this.ezAdventure = ezAdventure;
        this.server = server;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase2 lang(@NotNull String key) {
        return new VelocityEzAdventurePhase2(server, ezAdventure, audience -> ezAdventure.getLocalizedComponent(audience, key));
    }

    @Override
    public @NotNull VelocityEzAdventurePhase2 component(@NotNull ComponentLike component) {
        return new VelocityEzAdventurePhase2(server, ezAdventure, sender -> component);
    }
}
