package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventure;
import net.bobolabs.messages.EzAdventureOptions;
import net.bobolabs.messages.EzSendableComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Locale;

public class EzAdventure extends AbstractEzAdventure<CommandSender, Message> {

    private final JavaPlugin plugin;

    public EzAdventure(@NotNull JavaPlugin plugin, @NotNull EzAdventureOptions options) {
        super(langs, defaultLocale);
        this.plugin = plugin;
    }

    @NotNull
    @Override
    public EzSendableComponent<CommandSender, Message> getEzComponent(@NotNull CommandSender audience, @NotNull String key) {
        return null;
    }

    @Override
    public @NotNull Message ezify(@NotNull CommandSender audience, @NotNull ComponentLike component) {
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
