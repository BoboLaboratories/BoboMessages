package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractMessageManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;

public class MessageManager extends AbstractMessageManager<CommandSender, Message> {

    private final JavaPlugin plugin;

    public MessageManager(@NotNull JavaPlugin plugin, @NotNull File langs, @NotNull Locale defaultLocale) {
        super(langs, defaultLocale);
        this.plugin = plugin;
    }

    public MessageManager(@NotNull JavaPlugin plugin, @NotNull MiniMessage miniMessage, @NotNull File langs, @NotNull Locale defaultLocale) {
        super(miniMessage, langs, defaultLocale);
        this.plugin = plugin;
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
