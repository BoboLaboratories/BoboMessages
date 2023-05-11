package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventure;
import net.bobolabs.messages.AbstractEzAdventurePhase1;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

class BukkitEzAdventurePhase1 extends AbstractEzAdventurePhase1<CommandSender, BukkitEzAdventurePhase2, BukkitEzAdventurePhase3> {

    protected BukkitEzAdventurePhase1(@NotNull AbstractEzAdventure<CommandSender, ?, BukkitEzAdventurePhase2, BukkitEzAdventurePhase3> ezAdventure, boolean async) {
        super(ezAdventure, async);
    }

    @Override
    public final @NotNull BukkitEzAdventurePhase2 lang(@NotNull String key) {
        return new BukkitEzAdventurePhase2(audience -> getEzAdventure().getLocalizedComponent(audience, key));
    }

    @Override
    public final @NotNull BukkitEzAdventurePhase2 component(@NotNull ComponentLike component) {
        return new BukkitEzAdventurePhase2(sender -> component);
    }

}
