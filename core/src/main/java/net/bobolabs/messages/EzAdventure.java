package net.bobolabs.messages;

import net.bobolabs.core.Reloadable;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

interface EzAdventure<T extends Audience, U extends EzComponent<T, U>> extends Reloadable {

    @NotNull Component getComponent(@NotNull String key);

    @NotNull Component getComponent(@NotNull Locale locale, @NotNull String key);

    @NotNull Component getComponent(@NotNull T audience, @NotNull String key);

    @NotNull U getEzComponent(@NotNull String key);

    @NotNull U getEzComponent(@NotNull Locale locale, @NotNull String key);

    @NotNull EzSendableComponent<T, U> getEzComponent(@NotNull T audience, @NotNull String key);

    @NotNull U ezify(@NotNull T audience, @NotNull ComponentLike component);

    @NotNull Locale getDefaultLocale();

}
