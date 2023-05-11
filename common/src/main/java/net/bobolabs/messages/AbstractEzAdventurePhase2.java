package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public abstract class AbstractEzAdventurePhase2<A, P3 extends EzAdventurePhase3<A, P3>> implements EzAdventurePhase2<A, P3> {

    private final Function<@NotNull A, @NotNull ComponentLike> componentSupplier;

    protected AbstractEzAdventurePhase2(@NotNull Function<@NotNull A, @NotNull ComponentLike> componentSupplier) {
        this.componentSupplier = componentSupplier;
    }

    protected final @NotNull Function<@NotNull A, @NotNull ComponentLike> getComponentSupplier() {
        return componentSupplier;
    }

}
