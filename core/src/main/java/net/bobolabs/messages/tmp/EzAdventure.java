package net.bobolabs.messages.tmp;

import net.bobolabs.core.Reloadable;
import net.bobolabs.messages.EzComponent;
import net.bobolabs.messages.EzSendableComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.UUID;
import java.util.function.Predicate;

public interface EzAdventure<T> extends Reloadable {

    // Audience unaware

    @NotNull Component getComponent(@NotNull String key);

    @NotNull Component getComponent(@NotNull Locale locale, @NotNull String key);

    @NotNull EzComponent getEzComponent(@NotNull String key);

    @NotNull EzComponent getEzComponent(@NotNull Locale locale, @NotNull String key);

    @NotNull EzComponent ezify(@NotNull ComponentLike component);

    @NotNull Locale getDefaultLocale();


    // Audience aware

    @NotNull EzSendableComponent filter(@NotNull String key, @NotNull Predicate<T> filter);

    @NotNull EzSendableComponent permission(@NotNull String key, @NotNull String permission);

    @NotNull EzSendableComponent sender(@NotNull T sender, @NotNull String key);

    @NotNull EzSendableComponent sender(@NotNull UUID sender, @NotNull String key);

    @NotNull EzSendableComponent broadcast(@NotNull String key);

    @NotNull EzSendableComponent console(@NotNull String key);

    /*
        broadcast   -- all
        console
     */

    /*
        filter<T>   -- tutte le lib
        world       -- bukkit
        permission  -- tutte le lib                     // Key, string
        sender<T>   -- tutte le lib                     // player, uuid
        server      -- bungee/velocity                  // string... (varargs)
        broadcast   -- all
        console

     */

}
