package net.bobolabs.messages;

import net.bobolabs.core.Reloadable;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

interface OLDEzAdventure<T extends Audience> extends Reloadable {

    @NotNull Component getComponent(@NotNull String key);

    @NotNull Component getComponent(@NotNull Locale locale, @NotNull String key);

    @NotNull Component getComponent(@NotNull T audience, @NotNull String key);

    @NotNull Component permission(@NotNull String key, @NotNull String permission);

    @NotNull EzComponent getEzComponent(@NotNull String key);

    @NotNull EzComponent getEzComponent(@NotNull Locale locale, @NotNull String key);

    @NotNull EzSendableComponent getEzComponent(@NotNull T audience, @NotNull String key);

    @NotNull EzComponent ezify(@NotNull ComponentLike component);

    @NotNull EzSendableComponent ezify(@NotNull T audience, @NotNull ComponentLike component);

    @NotNull Locale getDefaultLocale();

    /*
        filter<T>   -- tutte le lib
        world       -- bukkit
        permission  -- tutte le lib                     // Key, string
        sender<T>   -- tutte le lib                     // player, uuid
        server      -- bungee/velocity
        broadcast   -- all
        console

     */

}
