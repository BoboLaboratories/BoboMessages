package net.bobolabs.messages.bukkit;

import net.bobolabs.messages.AbstractEzAdventure;
import net.bobolabs.messages.EzAdventureOptions;
import net.bobolabs.messages.EzSendableComponent;
import net.bobolabs.messages.tmp.EzInstanceAdventure;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.function.Predicate;

public class EzAdventure extends AbstractEzAdventure<CommandSender> implements EzInstanceAdventure<CommandSender> {

    private final BukkitAudiences audiences;
    private final JavaPlugin plugin;

    public EzAdventure(@NotNull JavaPlugin plugin, @NotNull EzAdventureOptions options) {
        super(options);
        this.plugin = plugin;
        this.audiences = BukkitAudiences.create(plugin);
    }


    public @NotNull BukkitAudiences getKyori() {
        return audiences;
    }








    @Override
    protected @NotNull Locale getLocale(@NotNull CommandSender audience) {
        if (audience instanceof Player player) {
            return player.locale();
        } else {
            return getDefaultLocale();
        }
    }

    @Override
    public @NotNull EzSendableComponent filter(@NotNull String key, @NotNull Predicate<CommandSender> filter) {
        for (CommandSender sender : Bukkit.getOnlinePlayers()) {

        }

        return null;
    }

}
