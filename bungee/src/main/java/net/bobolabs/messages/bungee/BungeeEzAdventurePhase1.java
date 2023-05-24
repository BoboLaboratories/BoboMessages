package net.bobolabs.messages.bungee;

import net.bobolabs.messages.AbstractEzAdventurePhase1;
import net.kyori.adventure.text.ComponentLike;
import net.md_5.bungee.api.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BungeeEzAdventurePhase1 extends AbstractEzAdventurePhase1<CommandSender, BungeeEzAdventurePhase2, BungeeEzAdventurePhase3> {

    private final BungeeEzAdventure ezAdventure;

    protected BungeeEzAdventurePhase1(@NotNull BungeeEzAdventure ezAdventure, boolean async) {
        super(ezAdventure, async);
        this.ezAdventure = ezAdventure;
    }

    @NotNull
    @Override
    public BungeeEzAdventurePhase2 lang(@NotNull String key) {
        return new BungeeEzAdventurePhase2(ezAdventure, audience -> ezAdventure.getLocalizedComponent(audience, key));
    }

    @NotNull
    @Override
    public BungeeEzAdventurePhase2 component(@NotNull ComponentLike component) {
        return new BungeeEzAdventurePhase2(ezAdventure, sender -> component);
    }
}
