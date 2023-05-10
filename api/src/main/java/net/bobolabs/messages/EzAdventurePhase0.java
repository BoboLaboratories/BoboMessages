package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

public interface EzAdventurePhase0
        <A,
        P1 extends EzAdventurePhase1<A, P2, P3>,
        P2 extends EzAdventurePhase2<A, P3>,
        P3 extends EzAdventurePhase3<A, P3>> extends EzAdventurePhase1<A, P2, P3> {

    @NotNull P1 sync();

    @NotNull P1 async();

}
