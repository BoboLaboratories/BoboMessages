package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

public interface InstanceEzAdventurePhase2<A, P3 extends EzAdventurePhase3<A, P3>, W> extends EzAdventurePhase2<A, P3> {

    @NotNull P3 world(@NotNull String world);

    @NotNull P3 world(@NotNull W world);

}
