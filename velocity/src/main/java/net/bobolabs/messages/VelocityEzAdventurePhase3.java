package net.bobolabs.messages;

import com.velocitypowered.api.command.CommandSource;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

// TODO: Non è possibile implementare i replace in AbstractEzAdventurePhase3?
//  bisognerebbe tenere in conto che dovrebbero essere risolti solamente una volta
//  invocato il .send()

// In questo modo l'unica cosa da implementare in questa classe sarebbe il .send()
// e il modo per risolvere i placeholder
public class VelocityEzAdventurePhase3
        extends AbstractEzAdventurePhase3<CommandSource, VelocityEzAdventurePhase3>
        implements EzAdventurePhase3<CommandSource, VelocityEzAdventurePhase3> {

    protected VelocityEzAdventurePhase3(@NotNull Supplier<@NotNull Collection<@NotNull CommandSource>> audience) {
        super(audience, replacements);
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replace(@NotNull CharSequence literal, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replace(@NotNull CharSequence literal, @NotNull Function<CommandSource, Object> replacement) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replaceAll(@NotNull String pattern, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replaceFirst(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull VelocityEzAdventurePhase3 replace(@NotNull UnaryOperator<String> replacement) {
        return null;
    }

    @Override
    public void send() {

    }
}
