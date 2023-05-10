package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public abstract class AbstractEzAdventurePhase0
        <A,
        P1 extends EzAdventurePhase1<A, P2, P3>,
        P2 extends EzAdventurePhase2<A, P3>,
        P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase0<A, P1, P2, P3> {

    private static final String DEFAULT_LINE_JOINER = "\n";

    protected AbstractEzAdventurePhase0() {
    }

    @Override
    public @NotNull P2 lang(@NotNull String key) {
        return sync().lang(key);
    }

    @Override
    public @NotNull P2 component(@NotNull ComponentLike component) {
        return sync().component(component);
    }

    @Override
    public @NotNull P2 text(@NotNull String text) {
        return sync().text(text);
    }

    @Override
    public @NotNull P2 text(@NotNull String[] text) {
        Collection<String> collection = List.of(text);
        return text(collection);
    }

    @Override
    public @NotNull P2 text(@NotNull Collection<String> text) {
        String joined = String.join(DEFAULT_LINE_JOINER, text);
        return text(joined);
    }

}
