package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class AbstractEzAdventurePhase1<A, P2 extends EzAdventurePhase2<A, P3>, P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase1<A, P2, P3> {

    private final boolean async;

    public AbstractEzAdventurePhase1(boolean async) {
        this.async = async;
    }

    @Override
    public @NotNull P2 lang(@NotNull String key) {
        return null;
    }

    @Override
    public @NotNull P2 text(@NotNull String text) {
        return null;
    }

    @Override
    public @NotNull P2 text(@NotNull String[] text) {
        return null;
    }

    @Override
    public @NotNull P2 text(@NotNull Collection<String> text) {
        return null;
    }

    @Override
    public @NotNull P2 component(@NotNull ComponentLike component) {
        return null;
    }

    protected boolean isAsync() {
        return async;
    }

}
