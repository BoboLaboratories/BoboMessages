package net.bobolabs.messages;

import net.bobolabs.core.Reloadable;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

interface MessageManager<T, U extends AbstractMessage<T, U>> extends Reloadable {

    @NotNull U getMessage(@NotNull T audience, @NotNull String key);

    @NotNull Locale getDefaultLocale();

}
