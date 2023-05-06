package net.bobolabs.messages;

import org.jetbrains.annotations.NotNull;

public interface MessageManager<T, U extends AbstractMessage<T>> extends Reloadable {

    @NotNull AbstractMessage getMessage(@NotNull T audience, @NotNull String key);

}
