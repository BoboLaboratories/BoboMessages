package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

public interface ProxyEzAdventurePhase2<A, P3 extends EzAdventurePhase3<A, P3>, S> extends EzAdventurePhase2<A, P3> {

    @NotNull P3 server(@NotNull S server);

}
