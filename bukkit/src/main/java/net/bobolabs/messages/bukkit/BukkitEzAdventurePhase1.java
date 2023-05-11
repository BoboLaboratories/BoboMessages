package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventurePhase1;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class BukkitEzAdventurePhase1 extends AbstractEzAdventurePhase1<CommandSender, BukkitEzAdventurePhase2, BukkitEzAdventurePhase3> {

    private final BukkitEzAdventure ezAdventure;

    protected BukkitEzAdventurePhase1(@NotNull BukkitEzAdventure ezAdventure, boolean async) {
        super(ezAdventure, async);
        this.ezAdventure = ezAdventure;
    }

    @Override
    public final @NotNull BukkitEzAdventurePhase2 lang(@NotNull String key) {
        return new BukkitEzAdventurePhase2(ezAdventure, audience -> ezAdventure.getLocalizedComponent(audience, key));
    }

    @Override
    public final @NotNull BukkitEzAdventurePhase2 component(@NotNull ComponentLike component) {
        return new BukkitEzAdventurePhase2(ezAdventure, sender -> component);
    }


}
