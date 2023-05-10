package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class AbstractEzAdventurePhase3<A, P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase3<A, P3> {

    private final Supplier<Collection<A>> audience;

    private final List<@NotNull Function<@NotNull ComponentLike, @NotNull ComponentLike>> replacements;

    protected AbstractEzAdventurePhase3(@NotNull Supplier<@NotNull Collection<@NotNull A>> audience) {
        this.audience = audience;
    }

    @Override
    public @NotNull P3 replace(@NotNull CharSequence target, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull P3 replace(@NotNull CharSequence target, @NotNull Function<A, Object> replacement) {
        return null;
    }

    @Override
    public @NotNull P3 replaceAll(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull P3 replaceFirst(@NotNull String regex, @NotNull Object replacement) {
        return null;
    }

    @Override
    public @NotNull P3 replace(@NotNull UnaryOperator<String> replacement) {
        return null;
    }

}
