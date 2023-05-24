package net.bobolabs.messages.bungee;

import net.bobolabs.messages.AbstractEzAdventurePhase3;
import net.kyori.adventure.text.ComponentLike;
import net.md_5.bungee.api.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

public class BungeeEzAdventurePhase3 extends AbstractEzAdventurePhase3<CommandSender, BungeeEzAdventurePhase3> {

    private final BungeeEzAdventure ezAdventure;

    protected BungeeEzAdventurePhase3(@NotNull BungeeEzAdventure ezAdventure,
                                      @NotNull Supplier<@NotNull Collection<@NotNull CommandSender>> audience,
                                      @NotNull Function<@NotNull CommandSender, @NotNull ComponentLike> componentSupplier) {
        super(ezAdventure, audience, componentSupplier);
        this.ezAdventure = ezAdventure;
    }

    @Override
    protected void send(@NotNull CommandSender audience, @NotNull ComponentLike component) {
        ezAdventure.getAudiences().sender(audience).sendMessage(component);
    }
}
