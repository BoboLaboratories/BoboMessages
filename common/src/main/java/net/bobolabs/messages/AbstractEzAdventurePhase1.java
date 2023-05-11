package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public abstract class AbstractEzAdventurePhase1<A, P2 extends EzAdventurePhase2<A, P3>, P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase1<A, P2, P3> {

    private static final String DEFAULT_LINE_JOINER = "\n";

    private final AbstractEzAdventure<A, ?, P2, P3> ezAdventure;
    private final boolean async;

    protected AbstractEzAdventurePhase1(@NotNull AbstractEzAdventure<A, ?, P2, P3> ezAdventure, boolean async) {
        this.ezAdventure = ezAdventure;
        this.async = async;
    }

    @Override
    public final @NotNull P2 text(@NotNull String text) {
        ComponentLike component = ezAdventure.miniMessage().deserialize(text);
        return component(component);
    }

    @Override
    public final @NotNull P2 text(@NotNull String[] text) {
        Collection<String> collection = List.of(text);
        return text(collection);
    }

    @Override
    public final @NotNull P2 text(@NotNull Collection<String> text) {
        String joined = String.join(DEFAULT_LINE_JOINER, text);
        return text(joined);
    }

    protected final boolean isAsync() {
        return async;
    }

    protected final @NotNull AbstractEzAdventure<A, ?, P2, P3> getEzAdventure() {
        return ezAdventure;
    }

}
