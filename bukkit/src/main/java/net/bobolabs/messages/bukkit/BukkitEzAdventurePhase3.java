package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventurePhase3;
import net.bobolabs.messages.EzAdventurePhase3;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

class BukkitEzAdventurePhase3
        extends AbstractEzAdventurePhase3<CommandSender, BukkitEzAdventurePhase3>
        implements EzAdventurePhase3<CommandSender, BukkitEzAdventurePhase3> {

    protected BukkitEzAdventurePhase3(@NotNull Supplier<@NotNull Collection<@NotNull CommandSender>> audience, @NotNull Function<@NotNull CommandSender, @NotNull ComponentLike> componentSupplier) {
        super(audience, componentSupplier);
    }

    @Override
    protected final void send(@NotNull CommandSender audience, @NotNull ComponentLike component) {
        audience.sendMessage(component);
    }

}
