package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Supplier;

public abstract class AbstractEzAdventurePhase3<A, P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase3<A, P3> {
    private final Supplier<Collection<A>> audience;

    protected AbstractEzAdventurePhase3(@NotNull Supplier<@NotNull Collection<@NotNull A>> audience) {
        this.audience = audience;
    }

}
