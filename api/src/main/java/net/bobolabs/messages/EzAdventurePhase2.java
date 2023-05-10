package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Predicate;

public interface EzAdventurePhase2<A, P3 extends EzAdventurePhase3<A, P3>> {

    @NotNull P3 filter(@NotNull Predicate<A> filter);

    @NotNull P3 permission(@NotNull String key);

    @NotNull P3 sender(@NotNull A sender);

    @NotNull P3 sender(@NotNull UUID sender);

    @NotNull P3 broadcast();

    @NotNull P3 console();

}
