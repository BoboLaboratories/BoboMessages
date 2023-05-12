package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface ProxyEzAdventurePhase2<A, P3 extends EzAdventurePhase3<A, P3>, S> extends EzAdventurePhase2<A, P3> {


    @NotNull P3 server(@NotNull S server);

    @NotNull P3 servers(@NotNull Collection<@NotNull S> servers);

}
