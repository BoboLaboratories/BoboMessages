package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class VelocityEzAdventurePhase3
        extends AbstractEzAdventurePhase3<CommandSource, VelocityEzAdventurePhase3>
        implements EzAdventurePhase3<CommandSource, VelocityEzAdventurePhase3> {

    protected VelocityEzAdventurePhase3(@NotNull Supplier<@NotNull Collection<@NotNull CommandSource>> audience) {
        super(audience);
    }

    @Override
    protected void send(@NotNull CommandSource audience, @NotNull ComponentLike component) {
        audience.sendMessage(component);
    }
}
