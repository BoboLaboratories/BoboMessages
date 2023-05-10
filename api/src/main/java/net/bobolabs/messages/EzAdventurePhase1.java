package net.bobolabs.messages;

import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface EzAdventurePhase1<A, P2 extends EzAdventurePhase2<A, P3>, P3 extends EzAdventurePhase3<A, P3>> {

    @NotNull P2 lang(@NotNull String key);

    @NotNull P2 component(@NotNull ComponentLike component);

    @NotNull P2 text(@NotNull String text);

    @NotNull P2 text(@NotNull String[] text);

    @NotNull P2 text(@NotNull Collection<String> text);

}
