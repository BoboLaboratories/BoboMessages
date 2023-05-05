package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractMessageManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class BukkitMessageManager extends AbstractMessageManager<Player> {

    private final JavaPlugin plugin;
    private final MiniMessage miniMessage;

    private BukkitMessageManager(@NotNull JavaPlugin plugin) {
        this.plugin = plugin;
        this.miniMessage = MiniMessage.miniMessage();
    }

    @Override
    protected @NotNull String getNamespace() {
        return plugin.getName();
    }

    @Override
    protected @NotNull Locale getLocale(@NotNull Player player) {
        return player.locale();
    }

}
