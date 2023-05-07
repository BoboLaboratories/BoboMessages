package net.bobolabs.messages;

import net.bobolabs.core.Reloadable;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

interface EzAdventure<T, U extends AbstractMessage<T, U>> extends Reloadable {

    @NotNull Component getComponent(@NotNull T audience, @NotNull String key);

    @NotNull U getMessage(@NotNull T audience, @NotNull String key);

    @NotNull Locale getDefaultLocale();

}
