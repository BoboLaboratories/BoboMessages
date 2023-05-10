package net.bobolabs.messages.tmp;

import net.bobolabs.messages.EzSendableComponent;
import org.jetbrains.annotations.NotNull;

public interface EzInstanceAdventure<T> extends EzAdventure<T> {

    @NotNull EzSendableComponent world(@NotNull String key);

}
