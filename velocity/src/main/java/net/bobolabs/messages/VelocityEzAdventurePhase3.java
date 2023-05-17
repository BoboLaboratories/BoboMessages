package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

public final class VelocityEzAdventurePhase3
        extends AbstractEzAdventurePhase3<CommandSource, VelocityEzAdventurePhase3>
        implements EzAdventurePhase3<CommandSource, VelocityEzAdventurePhase3> {

    public VelocityEzAdventurePhase3(@NotNull VelocityEzAdventure ezAdventure,
                                     @NotNull Supplier<@NotNull Collection<@NotNull CommandSource>> audience,
                                     @NotNull Function<@NotNull CommandSource, @NotNull ComponentLike> componentSupplier) {
        super(ezAdventure, audience, componentSupplier);
    }

    @Override
    protected void send(@NotNull CommandSource audience, @NotNull ComponentLike component) {
        audience.sendMessage(component);
    }
}
