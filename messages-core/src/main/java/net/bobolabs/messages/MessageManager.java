package net.bobolabs.messages;

import net.bobolabs.core.Reloadable;
import org.jetbrains.annotations.NotNull;

public interface MessageManager<P> extends Reloadable {

    @NotNull Message getMessage(@NotNull P player, @NotNull String key);

}
