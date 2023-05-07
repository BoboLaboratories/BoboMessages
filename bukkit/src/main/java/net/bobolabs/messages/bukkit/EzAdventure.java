package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventure;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;

public class EzAdventure extends AbstractEzAdventure<CommandSender, Message> {

    private final JavaPlugin plugin;

    public EzAdventure(@NotNull JavaPlugin plugin, @NotNull File langs, @NotNull Locale defaultLocale) {
        super(langs, defaultLocale);
        this.plugin = plugin;
    }

    public EzAdventure(@NotNull JavaPlugin plugin, @NotNull MiniMessage miniMessage, @NotNull File langs, @NotNull Locale defaultLocale) {
        super(miniMessage, langs, defaultLocale);
        this.plugin = plugin;
    }

    @Override
    public @NotNull Component getComponent(@NotNull CommandSender audience, @NotNull String key) {
        return null;
    }

    @Override
    protected @NotNull String getNamespace() {
        return plugin.getName();
    }

    @Override
    protected @NotNull Locale getLocale(@NotNull CommandSender audience) {
        if (audience instanceof Player player) {
            return player.locale();
        } else {
            return getDefaultLocale();
        }
    }

}
