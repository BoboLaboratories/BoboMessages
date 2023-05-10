package net.bobolabs.messages;

public interface EzAdventurePhase3<A, P3 extends EzAdventurePhase3<A, P3>> extends Replacer<A, P3> {

    void send();

}
