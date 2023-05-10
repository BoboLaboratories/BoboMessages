package net.bobolabs.messages.tmp;

import net.bobolabs.messages.EzSendableComponent;
import org.jetbrains.annotations.NotNull;

public interface EzProxyAdventure<T> extends EzAdventure<T> {

    @NotNull EzSendableComponent server(@NotNull String server);

}
